package com.taller_springflux.spring_reactor.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {

    @Bean
    public Cloudinary cloudinary(){
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dboaudmh9",
                "api_key", "839966864157916",
                "api_secret", "8cbhAPLIggwQhI3ANeP1q6_Gy6o"
                        ));
    }
}
