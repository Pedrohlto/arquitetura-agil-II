package com.minhaempresa.meuecommerce.apppagamento.application.ports.out;

import com.minhaempresa.meuecommerce.apppagamento.application.domain.Pagamento;

public interface CobrarCartaoOutputPort {

    Pagamento cobrar(Pagamento pagamento);
}
