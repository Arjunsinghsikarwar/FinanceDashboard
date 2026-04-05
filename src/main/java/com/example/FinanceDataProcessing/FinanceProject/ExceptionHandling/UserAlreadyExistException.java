package com.example.FinanceDataProcessing.FinanceProject.ExceptionHandling;

public class UserAlreadyExistException extends RuntimeException {

    public UserAlreadyExistException(String message)
    {
        super(message);
    }
}
