package com.minhaempresa.meuecommerce.appvenda.adapters.out.repository.entidades;


import com.minhaempresa.meuecommerce.appvenda.application.domain.StatusVenda;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "venda")
@Data
public class VendaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "data_venda")
    private LocalDate dataVenda;

    @Column(name = "cliente_id")
    private String clienteId;

    @Column(name = "valor_total")
    private BigDecimal valorTotal;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "venda")
    private List<ProdutoEntity> produtos;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "venda")
    private DadosPagamentoEntity dadosPagamento;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_venda")
    private StatusVenda statusVenda;

    public void prepareToSave() {
        this.produtos.forEach(produto -> produto.setVenda(this));
        this.dadosPagamento.setVenda(this);
    }
}
