package com.example.apiwords.config;


import org.springframework.web.servlet.config.annotation.CorsRegistry;

public class Config_cors {
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}
