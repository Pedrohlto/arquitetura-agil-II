package com.minhaempresa.meuecommerce.dto;

public record ProdutoPedidoDTO(ProdutoDTO produto,
                               Integer quantidade,
                               Double valor) {
}
