package com.minhaempresa.meuecommerce.appvenda.adapters.dto;

import com.minhaempresa.meuecommerce.appvenda.application.domain.TipoPagamento;
import com.fasterxml.jackson.annotation.JsonProperty;


public record DadosPagamentoDto(@JsonProperty("numero_cartao") String numeroCartao,
                                @JsonProperty("tipo_pagamento") TipoPagamento tipoPagamento,
                                @JsonProperty("nome_titular") String nomeTitular,
                                @JsonProperty("data_validade") String dataValidade,
                                @JsonProperty("codigo_seguranca") String codigoSeguranca) {
}
