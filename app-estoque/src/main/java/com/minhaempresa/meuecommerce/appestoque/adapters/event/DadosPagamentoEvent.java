package com.minhaempresa.meuecommerce.appestoque.adapters.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.minhaempresa.meuecommerce.appestoque.application.domain.TipoPagamento;


public record DadosPagamentoEvent(@JsonProperty("numero_cartao") String numeroCartao,
                                  @JsonProperty("tipo_pagamento") TipoPagamento tipoPagamento,
                                  @JsonProperty("nome_titular") String nomeTitular,
                                  @JsonProperty("data_validade") String dataValidade,
                                  @JsonProperty("codigo_seguranca") String codigoSeguranca) {
}
