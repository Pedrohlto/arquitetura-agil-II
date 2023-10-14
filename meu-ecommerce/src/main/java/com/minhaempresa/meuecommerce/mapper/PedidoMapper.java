package com.minhaempresa.meuecommerce.mapper;

import com.minhaempresa.meuecommerce.dto.PedidoDTO;
import com.minhaempresa.meuecommerce.model.Pedido;
import org.mapstruct.Mapper;

@Mapper
public interface PedidoMapper {

    Pedido toDomain(PedidoDTO pedido);

    PedidoDTO toDTO(Pedido pedido);
}
