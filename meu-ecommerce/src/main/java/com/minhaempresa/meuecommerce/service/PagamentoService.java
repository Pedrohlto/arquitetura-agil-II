package com.minhaempresa.meuecommerce.service;

import com.minhaempresa.meuecommerce.dto.PagamentoDTO;
import com.minhaempresa.meuecommerce.model.Pagamento;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.UUID;

@Service
public class PagamentoService {

    public Pagamento efetuarPagamento(PagamentoDTO dadosPagamento) {
        Pagamento pagamento = new Pagamento();
        pagamento.setTipoPagamento(dadosPagamento.tipoPagamento());
        pagamento.setDataPagamento(LocalDate.now());
        pagamento.setComprovante(UUID.randomUUID().toString());
        pagamento.setAutorizado(true);
        return pagamento;
    }
}
