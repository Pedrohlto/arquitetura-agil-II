package com.minhaempresa.meuecommerce.appvenda.adapters.out.repository.entidades;

import com.minhaempresa.meuecommerce.appvenda.application.domain.TipoPagamento;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "dados_pagamento")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DadosPagamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @OneToOne
    @JoinColumn(name = "venda_id")
    private VendaEntity venda;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_pagamento")
    private TipoPagamento tipoPagamento;

    @Column(name = "numero_cartao")
    private String numeroCartao;

    @Column(name = "nome_titular")
    private String nomeTitular;

    @Column(name = "data_validade")
    private String dataValidade;

    @Column(name = "codigo_seguranca")
    private String codigoSeguranca;


}
