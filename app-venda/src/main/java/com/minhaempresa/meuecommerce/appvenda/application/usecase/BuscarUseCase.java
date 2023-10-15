package com.minhaempresa.meuecommerce.appvenda.application.usecase;

import com.minhaempresa.meuecommerce.appvenda.application.domain.Venda;
import com.minhaempresa.meuecommerce.appvenda.application.ports.in.BuscarVendaInputPort;
import com.minhaempresa.meuecommerce.appvenda.application.ports.out.VendaRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscarUseCase implements BuscarVendaInputPort {

    @Autowired
    private VendaRepositoryPort vendaRepositoryPort;
    @Override
    public Venda buscar(String idVenda) {
        return vendaRepositoryPort.buscar(idVenda);
    }
}
