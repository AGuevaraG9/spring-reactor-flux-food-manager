package com.taller_springflux.spring_reactor.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DishDTO {
    private String id;
    @NotNull(message = "Attribute nameDishes must not be null")
    @Size(min = 2, max = 20)
    @Pattern(regexp = "^[A-Za-záéíóúñÁÉÍÓÚÑ ]+$", message = "Must comply with the pattern")
    private String nameDishes;
    @NotNull
    //@Min(value = 1)
    //@Max(value = 999, message = "The value must be under or equal to 999")
    @DecimalMin(value = "0.5")
    @DecimalMax(value = "999.99")
    private double priceDishes;
    @NotNull
    private boolean statusDishes;
    @NotNull
    @Email
    private String email;
}
