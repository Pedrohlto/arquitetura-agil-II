package com.minhaempresa.meuecommerce.apppagamento.adapters;

import com.fasterxml.jackson.annotation.JsonProperty;


public record DadosCobrancaDto(@JsonProperty("numero_cartao") String numeroCartao,
                               @JsonProperty("nome_titular") String nomeTitular,
                               @JsonProperty("data_validade") String dataValidade,
                               @JsonProperty("codigo_seguranca") String codigoSeguranca) {

}
