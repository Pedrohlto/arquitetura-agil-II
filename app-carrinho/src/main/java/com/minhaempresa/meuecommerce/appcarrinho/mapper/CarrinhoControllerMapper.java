package com.minhaempresa.meuecommerce.appcarrinho.mapper;

import com.minhaempresa.meuecommerce.appcarrinho.dto.CarrinhoDTO;
import com.minhaempresa.meuecommerce.appcarrinho.model.Carrinho;
import org.mapstruct.Mapper;

@Mapper
public interface CarrinhoControllerMapper {

    CarrinhoDTO toDTO(Carrinho carrinho);

    Carrinho toDomain(CarrinhoDTO carrinhoDTO);
}
