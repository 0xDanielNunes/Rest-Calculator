//package com.config;
//
//import lombok.Value;
//import org.springframework.context.annotation.Bean;
//
//import java.util.Queue;
//
//@org.springframework.context.annotation.Configuration
//public class Configuration {
//
//    @Value("${javainuse.rabbitmq.queue}")
//    String queueName;
//
//    @Value("${javainuse.rabbitmq.exchange}")
//    String exchange;
//
//    @Value("${javainuse.rabbitmq.routingkey}")
//    private String routingkey;
//
//    @Bean
//    Queue queue() {
//        return new Queue(queueName, false);
//    }
//
//    @Bean
//    DirectExchange exchange() {
//        return new DirectExchange(exchange);
//    }
//
//    @Bean
//    Binding binding(Queue queue, DirectExchange exchange) {
//        return BindingBuilder.bind(queue).to(exchange).with(routingkey);
//    }
//
//    @Bean
//    public MessageConverter jsonMessageConverter() {
//        return new Jackson2JsonMessageConverter();
//    }
//
//
//    @Bean
//    public AmqpTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
//        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
//        rabbitTemplate.setMessageConverter(jsonMessageConverter());
//        return rabbitTemplate;
//    }
//}
