package com.minhaempresa.meuecommerce.appvenda.adapters.dto;

import com.minhaempresa.meuecommerce.appvenda.application.domain.StatusVenda;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record VendaDto(String id,
                       List<ProdutoDto> produtos,
                       @JsonProperty("client_id") String clienteId,
                       String dataPedido,
                       String valorTotal,
                       @JsonProperty("dados_pagamento") DadosPagamentoDto dadosPagamento,
                       @JsonProperty("status_venda") StatusVenda statusVenda) {
}
