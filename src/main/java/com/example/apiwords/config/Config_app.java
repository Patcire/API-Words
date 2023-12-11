package com.example.apiwords.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Config_app {
    
    @Bean
    public ModelMapper model_mapper() {
        return new ModelMapper();
    }


}
