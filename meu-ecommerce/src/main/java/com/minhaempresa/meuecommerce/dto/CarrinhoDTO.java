package com.minhaempresa.meuecommerce.dto;

import java.util.List;

public record CarrinhoDTO (List<ProdutoCarrinhoDTO> produtos, Double valorTotal) {
}
