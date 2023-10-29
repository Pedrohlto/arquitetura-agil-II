package com.minhaempresa.meuecommerce.appvenda.adapters.in;

import com.minhaempresa.meuecommerce.appvenda.adapters.event.VendaEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerKafkaReservaSucesso {

    //@KafkaListener(topics = "estoque-sucesso", groupId = "app-venda")
    public void estoqueReservadoComSucesso(VendaEvent vendaEvent) {
        System.out.println("Estoque reservado com sucesso: " + vendaEvent.id());
    }
}
