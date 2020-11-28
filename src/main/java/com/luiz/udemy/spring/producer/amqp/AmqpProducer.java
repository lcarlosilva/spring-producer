package com.luiz.udemy.spring.producer.amqp;

public interface AmqpProducer<T> {
    void producer(T t);
}
