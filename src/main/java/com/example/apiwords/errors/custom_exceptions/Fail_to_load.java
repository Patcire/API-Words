package com.example.apiwords.errors.custom_exceptions;

public class Fail_to_load extends RuntimeException {
    public Fail_to_load(String message) {
        super(message);
    }
}
