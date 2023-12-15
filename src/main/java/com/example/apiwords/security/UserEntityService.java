package com.example.apiwords.security;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.example.apiwords.errors.custom_exceptions.New_user_with_different_pw;
import com.example.apiwords.security.user_model.CreateUserDto;
import com.example.apiwords.security.user_model.UserRole;
import com.example.apiwords.security.user_model.UserEntity;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserEntityService extends BaseService<UserEntity, Long, UserEntityRepository> {

    private final PasswordEncoder passwordEncoder;

    /**
     * Nos permite buscar un usuario por su nombre de usuario
     *
     * @param username
     * @return
     */
    public Optional<UserEntity> findUserByUsername(String username) {
        return this.repositorio.findByUsername(username);
    }

    /**
     * Nos permite crear un nuevo UserEntity con rol USER
     *
     * @param newUser
     * @return
     */
    public UserEntity nuevoUsuario(CreateUserDto newUser) {

        if (newUser.getPassword().contentEquals(newUser.getPassword2())) {
            UserEntity userEntity = UserEntity.builder().username(newUser.getUsername())
                    .password(passwordEncoder.encode(newUser.getPassword())).email(newUser.getEmail())
                    .roles(Stream.of(UserRole.USER).collect(Collectors.toSet())).build();
            try {
                return save(userEntity);
            } catch (DataIntegrityViolationException ex) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre de usuario ya existe");
            }
        } else {
            throw new New_user_with_different_pw("New_user_with_different_password");
        }

    }

}
