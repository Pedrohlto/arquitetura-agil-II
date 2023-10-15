package com.minhaempresa.meuecommerce.appestoque.application.domain;


import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class Reserva {

    public Reserva(String vendaId, List<Produto> produtos) {
        this.vendaId = vendaId;
        this.produtos = produtos;
        this.dataReserva = LocalDate.now();
    }

    private String vendaId;
    private List<Produto> produtos;
    private LocalDate dataReserva;


}
