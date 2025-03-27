package com.taller_springflux.spring_reactor.repository;

import com.taller_springflux.spring_reactor.model.Dish;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface DishRepository extends ReactiveMongoRepository<Dish, String> {
}
