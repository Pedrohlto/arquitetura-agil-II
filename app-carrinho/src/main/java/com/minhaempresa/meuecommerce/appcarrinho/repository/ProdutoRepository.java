package com.minhaempresa.meuecommerce.appcarrinho.repository;


import com.minhaempresa.meuecommerce.appcarrinho.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, String> {
}
