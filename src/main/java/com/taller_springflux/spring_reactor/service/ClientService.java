package com.taller_springflux.spring_reactor.service;

import com.taller_springflux.spring_reactor.model.Client;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientService {
    Mono<Client> save(Client client);
    Mono<Client> update(String id, Client client);
    Flux<Client> findAll();
    Mono<Client> findById(String id);
    Mono<Boolean> delete(String id);
}
