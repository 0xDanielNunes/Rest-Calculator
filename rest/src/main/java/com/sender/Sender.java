package com.sender;

import com.wrapper.OperationWrapper;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;

@Component
public class Sender {

    private static final Logger log = LoggerFactory.getLogger(Sender.class);

    private final RabbitTemplate rabbitTemplate;

    public Sender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    public String sendMessage(OperationWrapper wrapper){

        setRabbitTemplate();

        String queue = "messageQueue";

        log.info("Sending request = " + wrapper);

        String result = rabbitTemplate.convertSendAndReceiveAsType(queue
                , wrapper
                , new ParameterizedTypeReference<String>(){});

        log.info("Received a response! = " + result);

        return result;
    }

    private void setRabbitTemplate() {
        rabbitTemplate.setBeforePublishPostProcessors(message -> {

            String correlationId = MDC.get("correlationId");

            if (correlationId!=null && !correlationId.isEmpty()) {

                message.getMessageProperties().setHeader("correlationId", correlationId);

            }

            return message;

        });
    }
}
