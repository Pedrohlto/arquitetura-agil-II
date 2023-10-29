package com.minhaempresa.meuecommerce.orquestrador.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.minhaempresa.meuecommerce.orquestrador.domain.StatusVenda;

import java.util.List;

public record VendaDto(String id,
                       List<ProdutoDto> produtos,
                       @JsonProperty("client_id") String clienteId,
                       String dataPedido,
                       String valorTotal,
                       @JsonProperty("dados_pagamento") DadosPagamentoDto dadosPagamento,
                       @JsonProperty("status_venda") StatusVenda statusVenda) {
}
