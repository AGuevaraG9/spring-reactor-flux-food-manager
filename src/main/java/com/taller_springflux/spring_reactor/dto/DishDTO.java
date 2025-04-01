package com.taller_springflux.spring_reactor.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DishDTO {
    private String id;
    @Size(min = 2, max = 20)
    private String nameDishes;
    @NotNull
    @Min(value = 1)
    @Max(value = 999, message = "The value must be under or equal to 999")
    private double priceDishes;
    @NotNull
    private boolean statusDishes;
}
