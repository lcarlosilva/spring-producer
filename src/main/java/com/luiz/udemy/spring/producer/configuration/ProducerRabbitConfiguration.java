package com.luiz.udemy.spring.producer.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ProducerRabbitConfiguration {

    @Value("${spring.rabbitmq.request.exchange.producer}")
    private String exchange;

    @Value("${spring.rabbitmq.request.routing-key.producer}")
    private String queue;

    @Value("${spring.rabbitmq.request.deadlatter.producer}")
    private String deadLetter;

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(exchange);
    }

    @Bean
    public Queue deadLatter() {
        return new Queue(deadLetter);
    }

    @Bean
    public Queue queue() {
        Map<String, Object> args = new HashMap<>();
        args.put("x-dead-letter-exchange", exchange);
        args.put("x-dead-letter-routing-key", deadLetter);
        return new Queue(queue, true, false, false, args);
    }

    @Bean
    public Binding bindingQueue() {
        return BindingBuilder.bind(queue())
                .to(exchange()).with(queue);
    }

    @Bean
    public Binding bindingQueueDeadLetter() {
        return BindingBuilder.bind(deadLatter())
                .to(exchange()).with(deadLetter);
    }

}
