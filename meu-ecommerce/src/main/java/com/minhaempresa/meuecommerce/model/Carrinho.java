package com.minhaempresa.meuecommerce.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "carrinho")
@Data
public class Carrinho {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @OneToMany(mappedBy = "carrinho", cascade = CascadeType.ALL)
    private List<ProdutoCarrinho> produtos;

    @OneToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

}
