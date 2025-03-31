package com.taller_springflux.spring_reactor.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DishDTO {
    private String id;
    private String nameDishes;
    private double priceDishes;
    private boolean statusDishes;
}
