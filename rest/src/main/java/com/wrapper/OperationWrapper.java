package com.wrapper;

import lombok.*;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
