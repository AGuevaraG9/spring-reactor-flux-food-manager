package com.taller_springflux.spring_reactor.service;

import com.taller_springflux.spring_reactor.model.Client;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ClientService extends GenericCrud<Client, String>{

    Mono<Client> findByName(String string);
}
