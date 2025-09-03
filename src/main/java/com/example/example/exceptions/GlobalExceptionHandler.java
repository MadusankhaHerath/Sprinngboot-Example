package com.example.example.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    // This class can be used to handle global exceptions in the application.
    // You can define methods annotated with @ExceptionHandler to handle specific exceptions.
    // For example, you can handle ResourceNotFoundException or any other custom exceptions here.

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserNotFound(UserNotFoundException e, HttpServletRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), 404, LocalDateTime.now(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(userAlreadyExists.class)
    public ResponseEntity<ErrorResponse> handleAlreadyExistsFound(userAlreadyExists e, HttpServletRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), 404, LocalDateTime.now(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex, HttpServletRequest request) {
        ErrorResponse errorResponse = new ErrorResponse("Internal Server Error: " + ex.getMessage(), 500, LocalDateTime.now(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }


}