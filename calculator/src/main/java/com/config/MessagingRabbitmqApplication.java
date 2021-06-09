package com.config;

import com.model.OperationWrapper;
import com.service.CalculatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessagingRabbitmqApplication {
    private static final Logger log = LoggerFactory.getLogger(MessagingRabbitmqApplication.class);

    private final CalculatorService calculatorService;

    public MessagingRabbitmqApplication(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    @RabbitListener(queues = "messageQueue")
    public String listenSumMessage(OperationWrapper wrapper) {
        log.info("CalculatorService Receive Request Message: "+ wrapper);
        String result = calculatorService.calculate(wrapper);
        log.info("CalculatorService Send Response Message: "+result);
        return result;
    }
}
