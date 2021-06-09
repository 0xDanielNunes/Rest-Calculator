package com.business.exceptions;

public class DivideByZeroException extends ArithmeticException{

    public DivideByZeroException(String message){
        super(message);
    }
}
