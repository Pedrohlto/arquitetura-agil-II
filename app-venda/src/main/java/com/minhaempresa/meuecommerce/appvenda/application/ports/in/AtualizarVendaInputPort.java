package com.minhaempresa.meuecommerce.appvenda.application.ports.in;

import com.minhaempresa.meuecommerce.appvenda.application.domain.StatusVenda;

public interface AtualizarVendaInputPort {

    void atualizar(String idVenda, StatusVenda status, String motivo);
}
