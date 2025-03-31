package com.taller_springflux.spring_reactor.config;

import com.taller_springflux.spring_reactor.dto.DishDTO;
import com.taller_springflux.spring_reactor.model.Dish;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {
    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        // Mapping strategy //LOOSE, STANDARD, STRICT
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);

        //Customize mapping
        modelMapper.addMappings(new PropertyMap<Dish, DishDTO>() {
            @Override
            protected void configure() {
                map().setNameDishes(source.getName());
                map().setPriceDishes(source.getPrice());
                map().setStatusDishes(source.isStatus());
            }
        });

        return modelMapper;
    }
}
