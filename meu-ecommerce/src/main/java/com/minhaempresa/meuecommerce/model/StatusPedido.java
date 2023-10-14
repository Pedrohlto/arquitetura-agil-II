package com.minhaempresa.meuecommerce.model;

public enum StatusPedido {

    PROCESSANDO,
    AGUARDANDO_PAGAMENTO,
    PAGAMENTO_APROVADO,
    EM_SEPARACAO,
    EM_TRANSPORTE,
    ENTREGUE,
    CANCELADO, FRAUDE, NAO_AUTORIZADO;
}
