package com.example.FinanceDataProcessing.FinanceProject.ExceptionHandling;


public class ResourceNotFound extends RuntimeException{
    public ResourceNotFound(String message)
    {
        super(message);
    }
    public ResourceNotFound()
    {
        super("This Is Not Found");
    }
}
