package com.minhaempresa.meuecommerce.orquestrador.controller;

import com.minhaempresa.meuecommerce.orquestrador.dto.VendaDto;
import com.minhaempresa.meuecommerce.orquestrador.service.OrquestrarService;
import com.minhaempresa.meuecommerce.orquestrador.service.ProducerRabbit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orquestracao")
public class OrquestradorController {

    @Autowired
    private OrquestrarService orquestrarService;

    @Autowired
    private ProducerRabbit producerRabbit;

    @PostMapping
    public void orquestrar(@RequestBody VendaDto vendaDto) throws InterruptedException {
        System.out.println(vendaDto);
        Thread.sleep(1000);
    }

    @GetMapping
    public void orquestrar() throws InterruptedException {
        producerRabbit.send("envio de mensagem teste");
    }


}
