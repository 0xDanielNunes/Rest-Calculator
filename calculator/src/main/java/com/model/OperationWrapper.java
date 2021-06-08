package com.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperationWrapper implements Serializable {

    private static final long serialversionUID = 129348938L;

    private String a;

    private String b;

    private String op;

    @Override
    public String toString(){
        return "Op = " + op + "\n" +
                "a = " + a + "\n" +
                "b= " + b;
    }
}