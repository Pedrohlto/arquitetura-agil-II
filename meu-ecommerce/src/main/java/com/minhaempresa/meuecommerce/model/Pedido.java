package com.minhaempresa.meuecommerce.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private String id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(cascade=CascadeType.ALL, mappedBy="pedido", fetch = FetchType.EAGER)
    private List<ProdutoPedido> produtos;

    @Column(name = "data_pedido")
    private LocalDate dataPedido;

    @OneToOne(cascade= CascadeType.ALL, mappedBy="pedido")
    private Pagamento pagamento;

    @Column(name = "valor_total")
    private Double valorTotal;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private StatusPedido status;


}
