package com.taller_springflux.spring_reactor.repository;

import com.taller_springflux.spring_reactor.model.Client;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ClientRepository extends ReactiveMongoRepository<Client, String> {
}
