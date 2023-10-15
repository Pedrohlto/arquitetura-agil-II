package com.minhaempresa.meuecommerce.apppagamento.application.usecase;

import com.minhaempresa.meuecommerce.apppagamento.application.domain.Pagamento;
import com.minhaempresa.meuecommerce.apppagamento.application.ports.in.CriarPagamentoInputPort;
import com.minhaempresa.meuecommerce.apppagamento.application.ports.out.CobrarCartaoOutputPort;
import com.minhaempresa.meuecommerce.apppagamento.application.ports.out.PagamentoRepositoryPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CriarPagamentoUseCase implements CriarPagamentoInputPort {


    @Autowired
    private PagamentoRepositoryPort pagamentoRepositoryPort;

    @Autowired
    private CobrarCartaoOutputPort cobrarCartaoOutputPort;

    @Override
    public Pagamento criar(Pagamento pagamento) {
        var pagamentoCriado = cobrarCartaoOutputPort.cobrar(pagamento);
        return pagamentoRepositoryPort.save(pagamentoCriado);
    }
}
