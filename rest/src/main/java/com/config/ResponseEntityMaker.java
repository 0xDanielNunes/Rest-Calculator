package com.config;

import com.sender.Sender;
import com.wrapper.OperationWrapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseEntityMaker {

    private final static Logger log = LoggerFactory.getLogger(ResponseEntityMaker.class);

    public Sender sender;

    public ResponseEntityMaker(Sender sender) {
        this.sender = sender;
    }

    public ResponseEntity<String> newResponseEntity(String a, String b, String op){

        OperationWrapper request = new OperationWrapper(a,b,op);

        String result = "{\n" + "\"result: \"" + sender.sendMessage(request) + "\n}";

        HttpHeaders responseHeader = new HttpHeaders();

        responseHeader.setContentType(MediaType.APPLICATION_JSON);

        ResponseEntity<String> responseEntity;

        if(result.contains("You can't divide by 0!"))
            responseEntity = ResponseEntity.badRequest().headers(responseHeader).body(result);
        else
            responseEntity = ResponseEntity.ok().headers(responseHeader).body(result);

        log.info("Response sent: " + responseEntity);

        return responseEntity;
    }
}
