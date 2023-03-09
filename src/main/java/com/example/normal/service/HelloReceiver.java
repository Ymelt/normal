package com.example.normal.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RabbitListener(queues = "q_hello")
public class HelloReceiver {

    @RabbitHandler
    public void receiver(String message){
        System.out.println("We receiver" + message);
    }
}
