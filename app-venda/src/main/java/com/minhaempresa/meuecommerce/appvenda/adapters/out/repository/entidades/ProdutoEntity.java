package com.minhaempresa.meuecommerce.appvenda.adapters.out.repository.entidades;

import com.minhaempresa.meuecommerce.appvenda.application.domain.Produto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "venda_produto")
@NoArgsConstructor
@Data
public class ProdutoEntity {

    @EmbeddedId
    private ProdutoVendaId id;

    @Column(name = "produto_id", insertable = false, updatable = false)
    private String idProduto;

    @ManyToOne
    @JoinColumn(name = "venda_id",  insertable = false, updatable = false)
    private VendaEntity venda;

    @Column(name = "valor")
    private BigDecimal valor;

    @Column(name = "quantidade")
    private Integer quantidade;

    public ProdutoEntity(Produto produto){
        this.idProduto = produto.getId();
        this.valor = produto.getValor();
        this.quantidade = produto.getQuantidade();
    }

    @PrePersist
    public void montaPK(){
        this.id = new ProdutoVendaId(this.idProduto, this.venda.getId());
    }

    @Embeddable
    @AllArgsConstructor
    @NoArgsConstructor
    @ToString
    public static class ProdutoVendaId implements Serializable {

        @Column(name = "produto_id")
        private String produtoId;

        @Column(name="venda_id")
        private String vendaId;
    }
}
