package com.example.apiwords.security.user_model;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class UserDtoConverter {

    public GetUserDto convertUserEntityToGetUserDto(UserEntity user) {
        return GetUserDto.builder()
                .username(user.getUsername())
                .email(user.getEmail())
                .roles(user.getRoles().stream()
                        .map(UserRole::name)
                        .collect(Collectors.toSet())
                ).build();
    }

}
