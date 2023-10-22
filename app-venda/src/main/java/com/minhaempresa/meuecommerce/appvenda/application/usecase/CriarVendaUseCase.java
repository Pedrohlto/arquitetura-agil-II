package com.minhaempresa.meuecommerce.appvenda.application.usecase;

import com.minhaempresa.meuecommerce.appvenda.application.domain.Venda;
import com.minhaempresa.meuecommerce.appvenda.application.ports.in.CriarVendaInputPort;
import com.minhaempresa.meuecommerce.appvenda.application.ports.out.VendaCriadaEventPort;
import com.minhaempresa.meuecommerce.appvenda.application.ports.out.VendaRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CriarVendaUseCase implements CriarVendaInputPort {

    private final VendaCriadaEventPort vendaCriadaEventPort;
    private final VendaRepositoryPort vendaRepositoryPort;

    public Venda criar(Venda venda) {
        var vendaTEste = vendaRepositoryPort.save(venda);
        vendaCriadaEventPort.vendaCriada(vendaTEste);
        return vendaTEste;
    }
}
