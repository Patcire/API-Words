package com.example.apiwords.errors.custom_exceptions;

public class Exist extends RuntimeException {
    public Exist(String message) {
        super(message);
    }
}
