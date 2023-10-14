package com.minhaempresa.meuecommerce.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.minhaempresa.meuecommerce.model.TipoPagamento;

import java.time.LocalDate;

public record PagamentoDTO(String id,
                           @JsonProperty("tipo_pagamento") TipoPagamento tipoPagamento,
                           @JsonProperty("dados_cartao") DadosCartaoDTO dadosCartao,
                           @JsonProperty("data_pagamento") LocalDate dataPagamento) {
}
