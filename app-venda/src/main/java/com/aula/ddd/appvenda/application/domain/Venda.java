package com.aula.ddd.appvenda.application.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class Venda {

    private String id;
    private String clienteId;
    private List<Produto> produto;

    private BigDecimal valorTotal;

    private LocalDate dataVenda;

    public Venda(String clienteId, List<Produto> produto) {
        this.id = UUID.randomUUID().toString();
        this.clienteId = clienteId;
        this.produto = produto;
        this.valorTotal = produto.stream().map(Produto::getValor).reduce(BigDecimal.ZERO, BigDecimal::add);
        this.dataVenda = LocalDate.now();
    }

    public void incluirProduto(Produto produto) {
        if(produto == null)
            throw new IllegalArgumentException("Produto não pode ser nulo");

        this.produto.add(produto);
        this.valorTotal.add(produto.getValor());
    }

    public void removerProduto(Produto produto) {
        if(produto == null)
            throw new IllegalArgumentException("Produto não pode ser nulo");

        this.produto.remove(produto);
        this.valorTotal.subtract(produto.getValor());
    }

}
