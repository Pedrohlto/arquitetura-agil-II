package com.minhaempresa.meuecommerce.appvenda.application.ports.out;

import com.minhaempresa.meuecommerce.appvenda.application.domain.Venda;

public interface VendaCriadaEventPort {
    void vendaCriada(Venda venda);
}
