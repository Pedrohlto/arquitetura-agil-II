package com.minhaempresa.meuecommerce.orquestrador.controller;

import com.minhaempresa.meuecommerce.orquestrador.domain.DadosPagamento;
import com.minhaempresa.meuecommerce.orquestrador.domain.Venda;
import com.minhaempresa.meuecommerce.orquestrador.service.OrquestrarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orquestracao")
public class OrquestradorController {

    @Autowired
    private OrquestrarService orquestrarService;


    @PostMapping
    public void orquestrar(@RequestBody Venda venda) {
        orquestrarService.orquestrar();
    }
}
