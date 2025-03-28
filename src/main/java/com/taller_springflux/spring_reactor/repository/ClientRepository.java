package com.taller_springflux.spring_reactor.repository;

import com.taller_springflux.spring_reactor.model.Client;
import reactor.core.publisher.Mono;

public interface ClientRepository extends GenericRepository<Client, String> {

    Mono<Client> findByFirstName(String name);
}
