package com.minhaempresa.meuecommerce.apppagamento.adapters.in;


import com.minhaempresa.meuecommerce.apppagamento.adapters.PagamentoDto;
import com.minhaempresa.meuecommerce.apppagamento.adapters.PagamentoMapper;
import com.minhaempresa.meuecommerce.apppagamento.application.ports.in.CriarPagamentoInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {


    @Autowired
    private CriarPagamentoInputPort criarPagamentoInputPort;

    @Autowired
    private PagamentoMapper pagamentoMpapper;

    @PostMapping
    public PagamentoDto criar(@RequestBody PagamentoDto pagamentoDto) {
        var pagamentoCriado = criarPagamentoInputPort.criar(pagamentoMpapper.toDomain(pagamentoDto));
        return pagamentoMpapper.toDto(pagamentoCriado);
    }
}
