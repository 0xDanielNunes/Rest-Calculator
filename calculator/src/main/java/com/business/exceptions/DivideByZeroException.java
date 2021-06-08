package com.business.exceptions;

public class DivideByZeroException extends RuntimeException{

    public DivideByZeroException(String message){
        super(message);
    }
}
