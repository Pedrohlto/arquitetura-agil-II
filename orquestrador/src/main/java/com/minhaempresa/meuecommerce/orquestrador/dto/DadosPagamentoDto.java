package com.minhaempresa.meuecommerce.orquestrador.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.minhaempresa.meuecommerce.orquestrador.domain.TipoPagamento;


public record DadosPagamentoDto(@JsonProperty("numero_cartao") String numeroCartao,
                                @JsonProperty("tipo_pagamento") TipoPagamento tipoPagamento,
                                @JsonProperty("nome_titular") String nomeTitular,
                                @JsonProperty("data_validade") String dataValidade,
                                @JsonProperty("codigo_seguranca") String codigoSeguranca) {
}
