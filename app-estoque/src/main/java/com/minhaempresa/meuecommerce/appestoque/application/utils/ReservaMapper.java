package com.minhaempresa.meuecommerce.appestoque.application.utils;

import com.minhaempresa.meuecommerce.appestoque.adapters.dtos.ReservaDto;
import com.minhaempresa.meuecommerce.appestoque.adapters.out.repository.entidades.ProdutoEntity;
import com.minhaempresa.meuecommerce.appestoque.adapters.out.repository.entidades.ProdutoReservaEntity;
import com.minhaempresa.meuecommerce.appestoque.adapters.out.repository.entidades.ReservaEntity;
import com.minhaempresa.meuecommerce.appestoque.application.domain.Produto;
import com.minhaempresa.meuecommerce.appestoque.application.domain.Reserva;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface ReservaMapper {

    @Mapping(source="produtos", target="produtos", qualifiedByName = "mapProdutosEntity")
    Reserva toDomain(ReservaEntity reservaEntity);

    @Named("mapProdutosEntity")
    default List<Produto> mapProdutosEntity(List<ProdutoReservaEntity> produtos) {
        return produtos.
                stream().
                map(produtoEntity -> new Produto(produtoEntity.getProdutoId(), produtoEntity.getQuantidadeReservada()))
                .collect(Collectors.toList());
    }

    Reserva toDomain(ReservaDto reservaDto);

    ReservaDto toDto(Reserva reserva);
}
