package com.minhaempresa.meuecommerce.appvenda.application.domain;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class Produto {

    private String id;

    private BigDecimal valor;

    private Integer quantidade;

    public Produto(String id, BigDecimal valor, Integer quantidade) {
        this.id = id;
        this.valor = valor;
        this.quantidade = quantidade;
    }


}

