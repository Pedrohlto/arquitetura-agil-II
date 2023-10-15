package com.minhaempresa.meuecommerce.apppagamento.adapters.out;

import com.minhaempresa.meuecommerce.apppagamento.application.domain.Pagamento;
import com.minhaempresa.meuecommerce.apppagamento.application.domain.StatusPagamento;
import com.minhaempresa.meuecommerce.apppagamento.application.ports.out.CobrarCartaoOutputPort;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class GatewayPagamentoAdapter implements CobrarCartaoOutputPort {

    @Override
    public Pagamento cobrar(Pagamento pagamento) {

        if (pagamento.getValorPagamento().compareTo(BigDecimal.valueOf(1500L)) <= 0) {
            pagamento.setStatusPagamento(StatusPagamento.APROVADO);
        } else {
            pagamento.setStatusPagamento(StatusPagamento.NEGADO);
        }
        return pagamento;
    }
}
