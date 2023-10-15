package com.minhaempresa.meuecommerce.appvenda.application.ports.in;

import com.minhaempresa.meuecommerce.appvenda.application.domain.Venda;

public interface BuscarVendaInputPort {

    Venda buscar(String idVenda);
}
