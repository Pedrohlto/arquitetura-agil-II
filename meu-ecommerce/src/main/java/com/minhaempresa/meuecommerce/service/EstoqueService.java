package com.minhaempresa.meuecommerce.service;

import com.minhaempresa.meuecommerce.model.Pedido;
import org.springframework.stereotype.Service;

@Service
public class EstoqueService {

    public boolean reservaEstoque(Pedido pedido) {
        System.out.println("Itens Reservados");
        return true;
    }

    public boolean rollbackEstoque(Pedido pedido) {
        System.out.println("Itens liberados");
        return true;
    }
}
