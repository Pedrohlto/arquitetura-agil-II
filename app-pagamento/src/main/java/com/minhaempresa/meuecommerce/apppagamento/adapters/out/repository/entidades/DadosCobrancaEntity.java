package com.minhaempresa.meuecommerce.apppagamento.adapters.out.repository.entidades;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="dados_cobranca")
@Data
public class DadosCobrancaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @OneToOne
    @JoinColumn(name="pagamento_id")
    private PagamentoEntity pagamento;

    @Column(name="numero_cartao")
    private String numeroCartao;

    @Column(name="nome_titular")
    private String nomeTitular;

    @Column(name = "data_validade")
    private String dataValidade;

    @Column(name = "codigo_seguranca")
    private String codigoSeguranca;
}
