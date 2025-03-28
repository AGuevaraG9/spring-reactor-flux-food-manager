package com.taller_springflux.spring_reactor.service.impl;

import com.taller_springflux.spring_reactor.model.Client;
import com.taller_springflux.spring_reactor.repository.ClientRepository;
import com.taller_springflux.spring_reactor.repository.GenericRepository;
import com.taller_springflux.spring_reactor.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl extends GenericCrudImpl<Client, String> implements ClientService {

    private final ClientRepository clientRepository;

    @Override
    protected GenericRepository<Client, String> getRepository() {
        return clientRepository;
    }

    @Override
    public Mono<Client> findByName(String string) {
        return clientRepository.findByFirstName(string);
    }
}
