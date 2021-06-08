package com.service;

import com.business.Operations;
import com.business.OperationsImplementations;
import com.model.OperationWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    private static final Logger log = LoggerFactory.getLogger(CalculatorService.class);

    public String calculate(OperationWrapper wrapper) {

        String result = "";

        String op = wrapper.getOp();

        if(op == null || op.isEmpty()){
            result = new RuntimeException("The specified operation is not available. Please use either sum, sub, mul or div.").getMessage();
        }

        Operations calculator = new OperationsImplementations();

        String a = wrapper.getA();
        String b = wrapper.getB();

        if (op != null) {
            switch(op) {
                case "sum":
                    result = calculator.sum(a, b);
                    break;
                case "sub":
                    result = calculator.sub(a, b);
                    break;
                case "mul":
                    result = calculator.mul(a, b);
                    break;
                case "div":
                    result = calculator.div(a, b);
                    break;
            }
        }

        log.info("Result from " + a +
                op + " " + b + " was: "
                + result);

        return result;
    }
}
