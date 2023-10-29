package com.minhaempresa.meuecommerce.appvenda.application.usecase;

import com.minhaempresa.meuecommerce.appvenda.application.domain.Venda;
import com.minhaempresa.meuecommerce.appvenda.application.ports.in.CriarVendaInputPort;
import com.minhaempresa.meuecommerce.appvenda.application.ports.out.VendaCriadaEventPort;
import com.minhaempresa.meuecommerce.appvenda.application.ports.out.VendaRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class CriarVendaUseCase implements CriarVendaInputPort {

    private final VendaCriadaEventPort vendaCriadaEventPort;

    private final VendaRepositoryPort vendaRepositoryPort;

    public CriarVendaUseCase(@Qualifier("vendaCriadaAdapter") VendaCriadaEventPort vendaCriadaEventPort, VendaRepositoryPort vendaRepositoryPort) {
        this.vendaCriadaEventPort = vendaCriadaEventPort;
        this.vendaRepositoryPort = vendaRepositoryPort;
    }

    public Venda criar(Venda venda) {
        var vendaTeste = vendaRepositoryPort.save(venda);
        vendaCriadaEventPort.vendaCriada(vendaTeste);
        return vendaTeste;
    }
}
