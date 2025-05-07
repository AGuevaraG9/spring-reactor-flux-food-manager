package com.taller_springflux.spring_reactor.config;

import com.taller_springflux.spring_reactor.dto.ClientDTO;
import com.taller_springflux.spring_reactor.model.Client;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class MapperConfig {

    @Bean(name = "defaultMapper")
    public ModelMapper defaultMapper() {
        return new ModelMapper();
    }

    @Bean(name = "clientMapper")
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        // Mapping strategy //LOOSE, STANDARD, STRICT
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        //Customize writing mapping
        modelMapper.createTypeMap(ClientDTO.class, Client.class)
                .addMapping(ClientDTO::getName, (dest, v) -> dest.setFirstName((String) v))
                .addMapping(ClientDTO::getSurname, (dest, v) -> dest.setLastName((String) v))
                .addMapping(ClientDTO::getBirthDateClient, (dest, v) -> dest.setBirthDate((LocalDate) v))
                .addMapping(ClientDTO::getPicture, (dest, v) -> dest.setUrlPhoto((String) v));

        //Customize reading mapping
        modelMapper.createTypeMap(Client.class, ClientDTO.class)
                .addMapping(Client::getFirstName, (dest, v) -> dest.setName((String) v))
                .addMapping(Client::getLastName, (dest, v) -> dest.setSurname((String) v))
                .addMapping(Client::getBirthDate, (dest, v) -> dest.setBirthDateClient((LocalDate) v))
                .addMapping(Client::getUrlPhoto, (dest, v) -> dest.setPicture((String) v));

        return modelMapper;
    }
}
