package com.minhaempresa.meuecommerce.appestoque.adapters.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.minhaempresa.meuecommerce.appestoque.application.domain.StatusVenda;


public record AtualizacaoStatusEvent(@JsonProperty("status_venda") StatusVenda status, String motivo) {
}
