package service;

import model.Result;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class CalculatorOperations implements Operations{

    @Override
    public Result sum(String a, String b) {
        return new Result(BigDecimal.valueOf(Double.parseDouble(a)).add(BigDecimal.valueOf(Double.parseDouble(b))));
    }

    @Override
    public Result sub(String a, String b) {
        return new Result(BigDecimal.valueOf(Double.parseDouble(a)).subtract(BigDecimal.valueOf(Double.parseDouble(b))));
    }

    @Override
    public Result mul(String a, String b) {
        return new Result(
                BigDecimal.valueOf(Double.parseDouble(a)).multiply(BigDecimal.valueOf(Double.parseDouble(b))));
    }

    @Override
    public Result div(String a, String b) {
        return new Result(BigDecimal.valueOf(Double.parseDouble(a)).divide(BigDecimal.valueOf(Double.parseDouble(b))
                , 6
                ,RoundingMode.DOWN));
    }

}
