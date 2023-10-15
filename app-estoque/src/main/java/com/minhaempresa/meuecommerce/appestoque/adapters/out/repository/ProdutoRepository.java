package com.minhaempresa.meuecommerce.appestoque.adapters.out.repository;

import com.minhaempresa.meuecommerce.appestoque.adapters.out.repository.entidades.ProdutoEntity;
import feign.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ProdutoRepository extends JpaRepository<ProdutoEntity, String> {

    @Modifying
    @Query( value = "update PRODUTO set QUANTIDADE_DISPONIVEL = QUANTIDADE_DISPONIVEL - :quantidadeReservada where id = :produtoId", nativeQuery = true)
    void diminuiEstoque(@Param("produtoId") String produtoId, @Param("quantidadeReservada") Integer quantidadeReservada);
}
