package com.minhaempresa.meuecommerce.appestoque.application.ports.out;

import com.minhaempresa.meuecommerce.appestoque.application.domain.Produto;
import com.minhaempresa.meuecommerce.appestoque.application.domain.Reserva;

public interface ReservaRepositoryPort {

    Produto buscarProduto(String idProduto);
    Reserva criarReserva(Reserva reserva);
}
