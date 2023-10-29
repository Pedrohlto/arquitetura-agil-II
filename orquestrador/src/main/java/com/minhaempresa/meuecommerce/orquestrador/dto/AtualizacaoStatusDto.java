package com.minhaempresa.meuecommerce.orquestrador.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.minhaempresa.meuecommerce.orquestrador.domain.StatusVenda;


public record AtualizacaoStatusDto(@JsonProperty("status_venda") StatusVenda status, String motivo) {
}
