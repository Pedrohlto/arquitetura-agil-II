package com.minhaempresa.meuecommerce.apppagamento.application.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pagamento {

    private String id;
    private StatusPagamento statusPagamento;
    private String vendaId;
    private DadosCobranca dadosCobranca;
    private String autenticacaoPagamento;
    private LocalDate dataPagamento;
    private BigDecimal valorPagamento;


}
