package com.example.example.exceptions;

public class EmptyUsersException extends RuntimeException {
    public EmptyUsersException(String message) {
        super(message);
    }
}
