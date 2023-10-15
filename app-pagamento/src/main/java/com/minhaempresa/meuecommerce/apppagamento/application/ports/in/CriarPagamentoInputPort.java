package com.minhaempresa.meuecommerce.apppagamento.application.ports.in;

import com.minhaempresa.meuecommerce.apppagamento.application.domain.Pagamento;

public interface CriarPagamentoInputPort {
    Pagamento criar(Pagamento pagamento);
}
