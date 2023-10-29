package com.minhaempresa.meuecommerce.appvenda.adapters.out.evento;

import com.minhaempresa.meuecommerce.appvenda.adapters.VendaMapper;
import com.minhaempresa.meuecommerce.appvenda.adapters.event.VendaEvent;
import com.minhaempresa.meuecommerce.appvenda.application.domain.Venda;
import com.minhaempresa.meuecommerce.appvenda.application.ports.out.VendaCriadaEventPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Qualifier("vendaCriadaEventAdapter")
public class VendaCriadaEventoAdapter implements VendaCriadaEventPort {

    @Autowired
    private KafkaTemplate<String, VendaEvent> kafkaTemplate;

    @Autowired
    private VendaMapper vendaMapper;

    @Override
    public void vendaCriada(Venda venda) {
        var vendaEvent = vendaMapper.toEvent(venda);
        kafkaTemplate.send("venda-criada", vendaEvent);
    }
}
