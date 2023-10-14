package com.minhaempresa.meuecommerce.controller;

import com.minhaempresa.meuecommerce.dto.CarrinhoDTO;
import com.minhaempresa.meuecommerce.dto.ProdutoDTO;
import com.minhaempresa.meuecommerce.mapper.CarrinhoControllerMapper;
import com.minhaempresa.meuecommerce.service.CarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carrinhos/{id}")
public class CarrinhoController {


    @Autowired
    private CarrinhoService carrinhoService;

    @Autowired
    private CarrinhoControllerMapper carrinhoControllerMapper;

    @PostMapping("/produtos")
    public ResponseEntity<CarrinhoDTO> inserirProduto(@RequestBody ProdutoDTO produto, @PathVariable(name = "id") String idCarinho) {
        var carrinho = carrinhoService.inserirProduto(idCarinho, produto);
        return ResponseEntity.ok(carrinhoControllerMapper.toDTO(carrinho));
    }

    @GetMapping
    public ResponseEntity<CarrinhoDTO> listarProdutos(@PathVariable(name = "id") String idCarinho) {
         var carrinho = carrinhoService.listarProdutos(idCarinho);
        return ResponseEntity.ok(carrinhoControllerMapper.toDTO(carrinho));
    }

}
