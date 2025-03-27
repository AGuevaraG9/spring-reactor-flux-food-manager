package com.taller_springflux.spring_reactor.service.impl;

import com.taller_springflux.spring_reactor.model.Dish;
import com.taller_springflux.spring_reactor.repository.DishRepository;
import com.taller_springflux.spring_reactor.service.DishService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class DishServiceImpl implements DishService {

    private final DishRepository dishRepository;

    //Inyeccion por constructor
    /*public DishServiceImpl(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }*/

    //Inyeccion por constructor usando Autowired
    /*@Autowired
    public DishServiceImpl(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }*/

    //Inyeccion directa con Autowired
    //No recomendado por que presenta errores a la hora del testing
    /*@Autowired
    private DishRepository dishRepository2;*/

    //Inyeccion directa con Autowired en Setter
    //Utilizado en versiones iniciales de SpringBoot
    /*private DishRepository dishRepository2;

    @Autowired
    public void setDishRepository2(DishRepository dishRepository2) {
        this.dishRepository2 = dishRepository2;
    }*/

    @Override
    public Mono<Dish> save(Dish dish) {
        return dishRepository.save(dish);
    }

    @Override
    public Mono<Dish> update(String id, Dish dish) {
        return dishRepository.findById(id)
                .flatMap(dishExist -> {
                    dishExist.setName(dish.getName());
                    dishExist.setPrice(dish.getPrice());
                    dishExist.setStatus(dish.isStatus());
                    return dishRepository.save(dishExist);
                });
    }

    @Override
    public Flux<Dish> findAll() {
        return dishRepository.findAll();
    }

    @Override
    public Mono<Dish> findById(String id) {
        return dishRepository.findById(id);
    }

    @Override
    public Mono<Boolean> delete(String id) {
        return dishRepository.findById(id)
                .hasElement()
                .flatMap(result -> {
                    if (result) {
                        return dishRepository.deleteById(id).thenReturn(true);
                    } else {
                        return Mono.just(false);
                    }
                })
                ;
    }
}
