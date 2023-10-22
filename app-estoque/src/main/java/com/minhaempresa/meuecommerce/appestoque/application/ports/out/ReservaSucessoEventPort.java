package com.minhaempresa.meuecommerce.appestoque.application.ports.out;

import com.minhaempresa.meuecommerce.appestoque.adapters.event.VendaEvent;

public interface ReservaSucessoEventPort {
    void estoqueReservadoComSucesso(VendaEvent vendaEvent);
}
