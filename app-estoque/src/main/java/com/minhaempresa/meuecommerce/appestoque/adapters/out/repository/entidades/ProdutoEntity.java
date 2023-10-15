package com.minhaempresa.meuecommerce.appestoque.adapters.out.repository.entidades;


import com.minhaempresa.meuecommerce.appestoque.application.domain.Produto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "produto")
@Data
@NoArgsConstructor
public class ProdutoEntity {


    public ProdutoEntity(Produto produto){
        this.id = produto.getId();
        this.quantidadeDisponivel = produto.getQuantidadeDisponivel();
    }


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "quantidade_disponivel")
    private Integer quantidadeDisponivel;

}
