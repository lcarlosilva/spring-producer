package com.luiz.udemy.spring.producer.service.implementation;

import com.luiz.udemy.spring.producer.amqp.AmqpProducer;
import com.luiz.udemy.spring.producer.dto.Message;
import com.luiz.udemy.spring.producer.service.AmqpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQService implements AmqpService {

    @Autowired
    private AmqpProducer<Message> amqp;

    @Override
    public void sendToConsumer(Message message) {
        amqp.producer(message);
    }
}
