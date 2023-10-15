package com.minhaempresa.meuecommerce.orquestrador.dto.pagamento;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RespostaPagamentoDto {
    @JsonProperty("status_pagamento")
    private String statusPagamento;

}
