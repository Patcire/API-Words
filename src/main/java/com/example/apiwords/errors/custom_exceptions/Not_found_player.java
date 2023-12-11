package com.example.apiwords.errors.custom_exceptions;


public class Not_found_player extends RuntimeException {

    public Not_found_player(String message) {
        super(message);
    }

}
