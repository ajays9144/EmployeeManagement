package com.capco.employee.error;

/**
 * Exception Class for any details Not Found Exception.
 * */
public class IdNotFoundException extends RuntimeException
{
    public IdNotFoundException(String message) {
        super(message);
    }
}
