package com.minhaempresa.meuecommerce.appvenda.application.domain;

import com.minhaempresa.meuecommerce.appvenda.adapters.out.repository.entidades.VendaEntity;
import lombok.Data;

@Data
public class DadosPagamento {

    private String id;
    private VendaEntity venda;

    private TipoPagamento tipoPagamento;

    private String numeroCartao;

    private String nomeTitular;

    private String dataValidade;

    private String codigoSeguranca;

}
