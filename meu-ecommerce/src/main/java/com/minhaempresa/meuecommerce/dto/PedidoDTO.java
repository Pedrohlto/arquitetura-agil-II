package com.minhaempresa.meuecommerce.dto;

import com.minhaempresa.meuecommerce.model.StatusPedido;

import java.util.List;

public record PedidoDTO(String id, List<ProdutoPedidoDTO> produtos, String dataPedido, String valorTotal,
                        StatusPedido status) {
}
