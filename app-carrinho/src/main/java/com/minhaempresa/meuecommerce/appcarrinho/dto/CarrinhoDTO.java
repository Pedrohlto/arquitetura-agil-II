package com.minhaempresa.meuecommerce.appcarrinho.dto;

import java.util.List;

public record CarrinhoDTO(List<ProdutoCarrinhoDTO> produtos, Double valorTotal) {
}
