package com.minhaempresa.meuecommerce.appestoque.application.ports.in;

import com.minhaempresa.meuecommerce.appestoque.application.domain.Reserva;

public interface ReservaProdutoInputPort {
    Reserva reservar(Reserva reserva);
}
