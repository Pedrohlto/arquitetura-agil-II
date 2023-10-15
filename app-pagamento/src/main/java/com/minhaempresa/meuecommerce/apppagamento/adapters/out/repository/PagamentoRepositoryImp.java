package com.minhaempresa.meuecommerce.apppagamento.adapters.out.repository;

import com.minhaempresa.meuecommerce.apppagamento.adapters.PagamentoMapper;
import com.minhaempresa.meuecommerce.apppagamento.application.domain.Pagamento;
import com.minhaempresa.meuecommerce.apppagamento.application.ports.out.PagamentoRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PagamentoRepositoryImp implements PagamentoRepositoryPort {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private PagamentoMapper pagamentoMapper;

    @Override
    public Pagamento save(Pagamento pagamento) {
        var pagamentoEntity = pagamentoMapper.toEntity(pagamento);
        return pagamentoMapper.toDomain(pagamentoRepository.save(pagamentoEntity));
    }
}
