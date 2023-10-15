package com.minhaempresa.meuecommerce.apppagamento.adapters;

import com.minhaempresa.meuecommerce.apppagamento.adapters.out.repository.entidades.PagamentoEntity;
import com.minhaempresa.meuecommerce.apppagamento.application.domain.Pagamento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PagamentoMapper {

    PagamentoEntity toEntity(Pagamento pagamento);

    Pagamento toDomain(PagamentoEntity pagamentoEntity);

    @Mapping(target = "dadosCobranca.dataValidade", source = "dadosCobranca.dataValidade", dateFormat = "dd/MM/yyyy")
    Pagamento toDomain(PagamentoDto pagamentoDto);

    PagamentoDto toDto(Pagamento pagamento);

}
