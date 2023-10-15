package com.minhaempresa.meuecommerce.apppagamento.application.domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public class DadosCobranca {

    public DadosCobranca( String numeroCartao, String nomeTitular, LocalDate dataValidade, String codigoSeguranca) {
        validaVencimentoCartao(dataValidade);
        this.numeroCartao = numeroCartao;
        this.nomeTitular = nomeTitular;
        this.dataValidade = dataValidade;
        this.codigoSeguranca = codigoSeguranca;
    }
    private String numeroCartao;
    private String nomeTitular;
    private LocalDate dataValidade;
    private String codigoSeguranca;

    void validaVencimentoCartao(LocalDate dataValidade){
        if (dataValidade.isBefore(LocalDate.now())){
            throw new RuntimeException("Cartão vencido");
        }
    }

}
