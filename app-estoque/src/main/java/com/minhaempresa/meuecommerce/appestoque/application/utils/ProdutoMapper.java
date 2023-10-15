package com.minhaempresa.meuecommerce.appestoque.application.utils;

import com.minhaempresa.meuecommerce.appestoque.adapters.out.repository.entidades.ProdutoEntity;
import com.minhaempresa.meuecommerce.appestoque.application.domain.Produto;
import org.mapstruct.Mapper;

@Mapper
public interface ProdutoMapper {

    Produto toDomain(ProdutoEntity produtoEntity);

    ProdutoEntity toEntity(Produto produto);
}
