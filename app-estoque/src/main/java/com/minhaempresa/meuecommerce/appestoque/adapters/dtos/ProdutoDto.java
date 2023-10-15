package com.minhaempresa.meuecommerce.appestoque.adapters.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ProdutoDto(String id, @JsonProperty("quantidade_disponivel") Integer quantidadeDisponivel) {

}

