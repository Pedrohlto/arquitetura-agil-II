package com.minhaempresa.meuecommerce.appvenda.adapters.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.minhaempresa.meuecommerce.appvenda.application.domain.StatusVenda;

public record AtualizacaoStatusEvent(@JsonProperty("status_venda") StatusVenda status, String motivo) {
}
