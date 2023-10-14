package com.minhaempresa.meuecommerce.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record NovoPedidoRequest(@JsonProperty("id_carrinho") String idCarrinho,
                                @JsonProperty("pagamento") PagamentoDTO pagamento,
                                @JsonProperty("endereco_entrega") String enderecoEntrega,
                                @JsonProperty("observacoes") String observacoes) {}
