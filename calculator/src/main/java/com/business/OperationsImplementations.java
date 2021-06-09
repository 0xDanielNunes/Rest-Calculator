package com.business;

import com.business.exceptions.DivideByZeroException;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class OperationsImplementations implements Operations{

    @Override
    public String sum(String a, String b) {
        return BigDecimal.valueOf(Double.parseDouble(a))
                .add(BigDecimal.valueOf(Double.parseDouble(b)))
                .toString();
    }

    @Override
    public String sub(String a, String b) {
        return BigDecimal.valueOf(Double.parseDouble(a))
                .subtract(BigDecimal.valueOf(Double.parseDouble(b)))
                .toString();
    }

    @Override
    public String mul(String a, String b) {
        return BigDecimal.valueOf(Double.parseDouble(a))
                .multiply(BigDecimal.valueOf(Double.parseDouble(b)))
                .toString();
    }

    @Override
    public String div(String a, String b) {

        if(b.equals("0"))
            return "You can't divide by 0!";

        return BigDecimal.valueOf(Double.parseDouble(a)).divide(BigDecimal.valueOf(Double.parseDouble(b))
                , 6
                , RoundingMode.DOWN).toString();
    }

}
