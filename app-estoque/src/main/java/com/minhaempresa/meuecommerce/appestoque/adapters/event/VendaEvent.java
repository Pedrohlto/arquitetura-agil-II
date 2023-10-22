package com.minhaempresa.meuecommerce.appestoque.adapters.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.minhaempresa.meuecommerce.appestoque.application.domain.StatusVenda;

import java.util.List;

public record VendaEvent(String id,
                         List<ProdutoEvent> produtos,
                         @JsonProperty("client_id") String clienteId,
                         String dataPedido,
                         String valorTotal,
                         @JsonProperty("dados_pagamento") DadosPagamentoEvent dadosPagamento,
                         @JsonProperty("status_venda") StatusVenda statusVenda) {
}
