package com.example.FinanceDataProcessing.FinanceProject.ExceptionHandling;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message)
    {
        super(message);
    }
}
