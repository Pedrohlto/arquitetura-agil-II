package com.minhaempresa.meuecommerce.appvenda.adapters.out.repository;

import com.minhaempresa.meuecommerce.appvenda.adapters.VendaMapper;
import com.minhaempresa.meuecommerce.appvenda.application.domain.StatusVenda;
import com.minhaempresa.meuecommerce.appvenda.application.domain.Venda;
import com.minhaempresa.meuecommerce.appvenda.application.ports.out.VendaRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class VendaSavePort implements VendaRepositoryPort {

    @Autowired
    private final VendaRepository vendaRepository;

    @Autowired
    private final VendaMapper vendaMapper;

    @Override
    public Venda save(Venda venda) {
        var vendaEntity = vendaMapper.toEntity(venda);
        vendaEntity.prepareToSave();
        vendaRepository.save(vendaEntity);
        return vendaMapper.toDomain(vendaEntity);
    }

    @Override
    public void atualizaStatus(String idVenda, StatusVenda status, String motivo) {
        var venda = vendaRepository.findById(idVenda).orElseThrow(() -> new RuntimeException("Venda não encontrada"));
        venda.setStatusVenda(status);
        vendaRepository.save(venda);
    }

    @Override
    public Venda buscar(String idVenda) {
        var venda = vendaRepository.findById(idVenda).orElseThrow(() -> new RuntimeException("Venda não encontrada"));
        return vendaMapper.toDomain(venda);
    }


}
