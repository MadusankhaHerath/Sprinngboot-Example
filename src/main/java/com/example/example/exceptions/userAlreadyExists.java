package com.example.example.exceptions;

public class userAlreadyExists extends RuntimeException {
    public userAlreadyExists(String message) {
        super(message);
    }
}
