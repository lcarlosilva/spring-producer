package com.luiz.udemy.spring.producer.service;

import com.luiz.udemy.spring.producer.dto.Message;

public interface AmqpService {
    void sendToConsumer(Message message);
}
