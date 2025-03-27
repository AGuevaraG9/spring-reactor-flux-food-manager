package com.taller_springflux.spring_reactor.service;

import com.taller_springflux.spring_reactor.model.Dish;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DishService {
    Mono<Dish> save(Dish dish);
    Mono<Dish> update(String id, Dish dish);
    Flux<Dish> findAll();
    Mono<Dish> findById(String id);
    Mono<Boolean> delete(String id);
}
