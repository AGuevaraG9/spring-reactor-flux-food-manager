package com.taller_springflux.spring_reactor.service.impl;

import com.taller_springflux.spring_reactor.model.Client;
import com.taller_springflux.spring_reactor.repository.ClientRepository;
import com.taller_springflux.spring_reactor.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    public Mono<Client> save(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Mono<Client> update(String id, Client client) {
        return clientRepository.findById(id)
                .flatMap(e -> clientRepository.save(client));
    }

    @Override
    public Flux<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Mono<Client> findById(String id) {
        return clientRepository.findById(id);
    }

    @Override
    public Mono<Boolean> delete(String id) {
        return clientRepository.findById(id)
                .hasElement()
                .flatMap(result -> {
                    if (result) {
                        return clientRepository.deleteById(id).thenReturn(true);
                    } else {
                        return Mono.just(false);
                    }
                });
    }
}
