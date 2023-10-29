package com.minhaempresa.meuecommerce.orquestrador.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerRabbit {
    //@RabbitListener(queues = "vendaCriada")
    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
    }

}
