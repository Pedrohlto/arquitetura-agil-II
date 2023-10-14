package com.minhaempresa.meuecommerce.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Table(name = "produto_pedido")
@Data
public class ProdutoPedido {

    @EmbeddedId
    private ProdutoPedidoId pedidoId;

    @ManyToOne(optional = false)
    @JoinColumn(name = "pedido_id", insertable = false, updatable = false)
    private Pedido pedido;

    @ManyToOne(optional = false)
    @JoinColumn(name = "produto_id", insertable = false, updatable = false)
    private Produto produto;

    private Integer quantidade;

    private double valor;


    @PrePersist
    private void montaPk(){
        this.pedidoId = new ProdutoPedidoId();
        this.pedidoId.setPedidoId(this.pedido.getId());
        this.pedidoId.setProdutoId(this.produto.getId());
    }

    @Embeddable
    @Data
    public static class ProdutoPedidoId implements Serializable {

        @Column(name = "produto_id")
        private String produtoId;

        @Column(name = "pedido_id")
        private String pedidoId;
    }

}

