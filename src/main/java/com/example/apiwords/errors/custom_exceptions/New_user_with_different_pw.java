package com.example.apiwords.errors.custom_exceptions;

import java.util.Scanner;

public class New_user_with_different_pw extends RuntimeException {
    public New_user_with_different_pw(String message) {
        super(message);
    }

}
