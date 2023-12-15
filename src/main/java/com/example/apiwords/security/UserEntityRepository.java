package com.example.apiwords.security;

import java.util.Optional;

import com.example.apiwords.security.user_model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String username);

}
