package com.minhaempresa.meuecommerce.service;

import com.minhaempresa.meuecommerce.dto.ProdutoDTO;
import com.minhaempresa.meuecommerce.model.Carrinho;
import com.minhaempresa.meuecommerce.model.ProdutoCarrinho;
import com.minhaempresa.meuecommerce.repository.CarrinhoRepository;
import com.minhaempresa.meuecommerce.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public Carrinho inserirProduto(String idCarinho, ProdutoDTO produtoDTO) {
        var carrinho = carrinhoRepository.findById(idCarinho).get();
        var produto = produtoRepository.findById(produtoDTO.id()).get();
        ProdutoCarrinho produtoCarrinho = new ProdutoCarrinho();
        produtoCarrinho.setProduto(produto);
        produtoCarrinho.setQuantidade(produtoDTO.quantidade());
        produtoCarrinho.setValor(produto.getValor());
        produtoCarrinho.setCarrinho(carrinho);
        carrinho.getProdutos().add(produtoCarrinho);
        return carrinhoRepository.save(carrinho);
    }

    public Carrinho listarProdutos(String idCarinho) {
        return carrinhoRepository.findById(idCarinho).get();
    }
}
