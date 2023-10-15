package com.minhaempresa.meuecommerce.appestoque.adapters.out.repository;

import com.minhaempresa.meuecommerce.appestoque.adapters.out.repository.entidades.ReservaEntity;
import com.minhaempresa.meuecommerce.appestoque.application.domain.Produto;
import com.minhaempresa.meuecommerce.appestoque.application.domain.Reserva;
import com.minhaempresa.meuecommerce.appestoque.application.ports.out.ReservaRepositoryPort;
import com.minhaempresa.meuecommerce.appestoque.application.utils.ProdutoMapper;
import com.minhaempresa.meuecommerce.appestoque.application.utils.ReservaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ProdutoRepositoryImp implements ReservaRepositoryPort {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private ProdutoMapper produtoMapper;

    @Autowired
    private ReservaMapper reservaMapper;

    @Override
    public Produto buscarProduto(String idProduto) {
        var produtoentity = produtoRepository.findById(idProduto).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        return produtoMapper.toDomain(produtoentity);
    }

    @Override
    @Transactional
    public Reserva criarReserva(Reserva reserva) {
        var reservaEntity = new ReservaEntity(reserva);
        reservaEntity.preparaInsert();
        var reservaSalva = reservaRepository.save(reservaEntity);

        reservaEntity.getProdutos().forEach(produto ->{
            produtoRepository.diminuiEstoque(produto.getProdutoId(), produto.getQuantidadeReservada());
        });

        return reservaMapper.toDomain(reservaSalva);
    }
}
