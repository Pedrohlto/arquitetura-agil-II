package com.minhaempresa.meuecommerce.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Table(name = "pagamento")
@Entity
@Data
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Enumerated(EnumType.STRING)
    private TipoPagamento tipoPagamento;

    @Column(name = "data_pagamento")
    private LocalDate dataPagamento;

    @Column(name = "comprovante")
    private String comprovante;

    @Column(name = "autorizado")
    private Boolean autorizado;

    @OneToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

}
