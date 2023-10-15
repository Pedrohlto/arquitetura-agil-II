package com.minhaempresa.meuecommerce.appvenda.application.usecase;

import com.minhaempresa.meuecommerce.appvenda.application.domain.StatusVenda;
import com.minhaempresa.meuecommerce.appvenda.application.ports.in.AtualizarVendaInputPort;
import com.minhaempresa.meuecommerce.appvenda.application.ports.out.VendaRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AtualizarVendaUseCase implements AtualizarVendaInputPort {


    private final VendaRepositoryPort vendaRepositoryPort;

    @Override
    public void atualizar(String idVenda, StatusVenda status, String motivo) {

        vendaRepositoryPort.atualizaStatus(idVenda, status, motivo);
    }
}
