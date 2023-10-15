package com.minhaempresa.meuecommerce.appvenda.application.ports.out;

import com.minhaempresa.meuecommerce.appvenda.application.domain.StatusVenda;
import com.minhaempresa.meuecommerce.appvenda.application.domain.Venda;

public interface VendaRepositoryPort {
    Venda save(Venda venda);
    void atualizaStatus(String idVenda, StatusVenda status, String motivo);

    Venda buscar(String idVenda);
}
