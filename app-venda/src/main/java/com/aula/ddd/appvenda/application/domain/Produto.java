package com.aula.ddd.appvenda.application.domain;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class Produto {

    public Produto(String id, BigDecimal valor, String descricao, String nome) {
        this.id = id;
        this.valor = valor;
        this.descricao = descricao;
        this.nome = nome;
    }

    private String id;

    private BigDecimal valor;

    private String descricao;

    private String nome;
}
