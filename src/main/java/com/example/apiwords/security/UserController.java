package com.example.apiwords.security;

import com.example.apiwords.security.user_model.CreateUserDto;
import com.example.apiwords.security.user_model.GetUserDto;
import com.example.apiwords.security.user_model.UserDtoConverter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserEntityService userEntityService;
    private final UserDtoConverter userDtoConverter;


    @PostMapping("/")
    public GetUserDto nuevoUsuario(@RequestBody CreateUserDto newUser) {
        return userDtoConverter.convertUserEntityToGetUserDto(userEntityService.nuevoUsuario(newUser));

    }

}
