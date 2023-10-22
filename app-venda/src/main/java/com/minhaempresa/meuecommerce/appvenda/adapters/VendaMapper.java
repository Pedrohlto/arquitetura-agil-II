package com.minhaempresa.meuecommerce.appvenda.adapters;

import com.minhaempresa.meuecommerce.appvenda.adapters.dto.VendaDto;
import com.minhaempresa.meuecommerce.appvenda.adapters.event.VendaEvent;
import com.minhaempresa.meuecommerce.appvenda.adapters.out.repository.entidades.DadosPagamentoEntity;
import com.minhaempresa.meuecommerce.appvenda.adapters.out.repository.entidades.ProdutoEntity;
import com.minhaempresa.meuecommerce.appvenda.adapters.out.repository.entidades.VendaEntity;
import com.minhaempresa.meuecommerce.appvenda.application.domain.DadosPagamento;
import com.minhaempresa.meuecommerce.appvenda.application.domain.Produto;
import com.minhaempresa.meuecommerce.appvenda.application.domain.Venda;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface VendaMapper {


    VendaDto toDto(Venda venda);

    VendaEvent toEvent(Venda venda);
    Venda toDomain(VendaDto vendaDTO);

    @Mapping(source = "produtos", target = "produtos", qualifiedByName = "mapProdutosEntity")
    Venda toDomain(VendaEntity entity);

    @Named("mapProdutosEntity")
    default List<Produto> mapProdutosEntity(List<ProdutoEntity> produtos) {
        return produtos.
                stream().
                map(produtoEntity -> new Produto(produtoEntity.getIdProduto(), produtoEntity.getValor(), produtoEntity.getQuantidade()))
                .collect(Collectors.toList());
    }

    @Mapping(source = "produtos", target = "produtos", qualifiedByName = "mapProdutos")
    @Mapping(source = "dadosPagamento", target = "dadosPagamento", qualifiedByName = "mapDadosPagamento")
    VendaEntity toEntity(Venda venda);

    @Named("mapProdutos")
    default List<ProdutoEntity> mapProdutos(List<Produto> produtos) {
        return produtos.
                stream().
                map(ProdutoEntity::new)
                .collect(Collectors.toList());
    }

    @Named("mapDadosPagamento")
    default DadosPagamentoEntity mapDadosPagamento(DadosPagamento dadosPagamento) {
        DadosPagamentoEntity pagamentoEntity = new DadosPagamentoEntity();
        pagamentoEntity.setTipoPagamento(dadosPagamento.getTipoPagamento());
        pagamentoEntity.setNumeroCartao(dadosPagamento.getNumeroCartao());
        pagamentoEntity.setNomeTitular(dadosPagamento.getNomeTitular());
        pagamentoEntity.setDataValidade(dadosPagamento.getDataValidade());
        pagamentoEntity.setCodigoSeguranca(dadosPagamento.getCodigoSeguranca());
        return pagamentoEntity;
    }

}
