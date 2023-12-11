package com.example.apiwords.errors.custom_exceptions;

public class Player_exist extends RuntimeException {
    public Player_exist(String message) {
        super(message);
    }
}
