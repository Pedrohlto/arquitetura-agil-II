package com.minhaempresa.meuecommerce.appvenda.application.ports.in;

import com.minhaempresa.meuecommerce.appvenda.application.domain.Venda;

public interface CriarVendaInputPort {
    Venda criar(Venda venda) throws InterruptedException;
}
