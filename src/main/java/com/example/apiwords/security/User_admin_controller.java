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
@RequestMapping("/admin")
@RequiredArgsConstructor
public class User_admin_controller {

    private final UserEntityService userEntityService;
    private final UserDtoConverter userDtoConverter;


    @PostMapping("/create")
    public GetUserDto new_user(@RequestBody CreateUserDto new_user) {
        return userDtoConverter.convertUserEntityToGetUserDto(userEntityService.nuevoUsuario(new_user));

    }

}
