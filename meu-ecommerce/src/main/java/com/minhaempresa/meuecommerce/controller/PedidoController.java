package com.minhaempresa.meuecommerce.controller;

import com.minhaempresa.meuecommerce.dto.NovoPedidoRequest;
import com.minhaempresa.meuecommerce.dto.PedidoDTO;
import com.minhaempresa.meuecommerce.mapper.PedidoMapper;
import com.minhaempresa.meuecommerce.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private PedidoMapper pedidoControllerMapper;


    @PostMapping
    public ResponseEntity<PedidoDTO> criarPedido(@RequestBody NovoPedidoRequest pedido) {
        var pedidoCriado = pedidoService.criarNovoPedido(pedido);
        return ResponseEntity.ok(pedidoControllerMapper.toDTO(pedidoCriado));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTO> buscaPorId(@PathVariable String id) {
        var pedido = pedidoControllerMapper.toDTO(pedidoService.buscarPorId(id));
        return ResponseEntity.ok(pedido);
    }

    @GetMapping
    public ResponseEntity<List<PedidoDTO>> listar() {
        var pedidos = pedidoService.listarPedidos();
        var pedidosDto = pedidos.stream().map(pedidoControllerMapper::toDTO).collect(Collectors.toList());
        return ResponseEntity.ok(pedidosDto);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<PedidoDTO> atualizarPedido(@RequestBody PedidoDTO pedidoDto, @PathVariable String id) throws InvocationTargetException, IllegalAccessException {
        var pedido = pedidoService.atualizarPedido(pedidoControllerMapper.toDomain(pedidoDto), id);
        return ResponseEntity.ok(pedidoControllerMapper.toDTO(pedido));
    }

}
