package com.minhaempresa.meuecommerce.appvenda.adapters.dto;

import com.minhaempresa.meuecommerce.appvenda.application.domain.StatusVenda;
import com.fasterxml.jackson.annotation.JsonProperty;

public record AtualizacaoStatusDto(@JsonProperty("status_venda") StatusVenda status, String motivo) {
}
