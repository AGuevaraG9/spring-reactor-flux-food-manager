package com.taller_springflux.spring_reactor.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepository<T, ID> extends ReactiveMongoRepository<T, ID> {
}
