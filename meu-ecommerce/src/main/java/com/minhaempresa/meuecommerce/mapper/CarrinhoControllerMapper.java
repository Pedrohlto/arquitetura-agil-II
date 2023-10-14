package com.minhaempresa.meuecommerce.mapper;

import com.minhaempresa.meuecommerce.dto.CarrinhoDTO;
import com.minhaempresa.meuecommerce.model.Carrinho;
import org.mapstruct.Mapper;

@Mapper
public interface CarrinhoControllerMapper {

    CarrinhoDTO toDTO(Carrinho carrinho);

    Carrinho toDomain(CarrinhoDTO carrinhoDTO);
}
