package com.example.FinanceDataProcessing.FinanceProject.ExceptionHandling;

import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalException {

   @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String,String>> RuntimeException(RuntimeException ex)
    {
        return new ResponseEntity<>(Map.of("message",ex.getMessage()), HttpStatusCode.valueOf(404));
    }

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<String> resourceNotFound(ResourceNotFound ex)
    {
        return ResponseEntity.status(404).body(ex.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Map<String,String>> illegalArgumentException(IllegalArgumentException ex)
    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("message",ex.getMessage()));
    }

    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<Map<String,String>> handleUserAlreadyExistException(UserAlreadyExistException ex)
    {
        return ResponseEntity.status(404).body(Map.of("error",ex.getMessage()));
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Map<String,String>> userNotFoundException(UserNotFoundException ex)
    {
        return new ResponseEntity<>(Map.of("message",ex.getMessage()),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<Map<String,String>> handleBadCredentials() {
        return ResponseEntity.status(401)
                .body(Map.of("error", "Invalid username or password"));
    }

}
