package com.minhaempresa.meuecommerce.appvenda.application.ports.in;

import com.minhaempresa.meuecommerce.appvenda.application.domain.StatusVenda;
import com.minhaempresa.meuecommerce.appvenda.application.domain.Venda;

public interface VendaInputPort {

    Venda criar(Venda venda);

    void atualizar(String idVenda, StatusVenda status, String motivo);

    Venda buscar(String idVenda);

}
