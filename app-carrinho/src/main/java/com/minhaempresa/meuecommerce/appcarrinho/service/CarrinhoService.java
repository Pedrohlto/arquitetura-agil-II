package com.minhaempresa.meuecommerce.appcarrinho.service;


import com.minhaempresa.meuecommerce.appcarrinho.dto.ProdutoDTO;
import com.minhaempresa.meuecommerce.appcarrinho.model.Carrinho;
import com.minhaempresa.meuecommerce.appcarrinho.model.ProdutoCarrinho;
import com.minhaempresa.meuecommerce.appcarrinho.repository.CarrinhoRepository;
import com.minhaempresa.meuecommerce.appcarrinho.repository.ProdutoRepository;
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

    public Carrinho listarProdutos(String idCarinho) throws InterruptedException {
        Thread.sleep(3000);
        return carrinhoRepository.findById(idCarinho).get();
    }
}
