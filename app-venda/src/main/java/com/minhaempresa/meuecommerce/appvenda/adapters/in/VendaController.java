package com.minhaempresa.meuecommerce.appvenda.adapters.in;

import com.minhaempresa.meuecommerce.appvenda.adapters.VendaMapper;
import com.minhaempresa.meuecommerce.appvenda.adapters.dto.AtualizacaoStatusDto;
import com.minhaempresa.meuecommerce.appvenda.adapters.dto.VendaDto;
import com.minhaempresa.meuecommerce.appvenda.application.ports.in.AtualizarVendaInputPort;
import com.minhaempresa.meuecommerce.appvenda.application.ports.in.BuscarVendaInputPort;
import com.minhaempresa.meuecommerce.appvenda.application.ports.in.CriarVendaInputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vendas")
public class VendaController {

    @Autowired
    private CriarVendaInputPort criarVendaInputPort;

    @Autowired
    private AtualizarVendaInputPort atualizarVendaInputPort;

    @Autowired
    private BuscarVendaInputPort buscarVendaInputPort;

    @Autowired
    private VendaMapper vendaMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VendaDto criar(@RequestBody VendaDto vendaDTO) {
        var venda = vendaMapper.toDomain(vendaDTO);
        return vendaMapper.toDto(criarVendaInputPort.criar(venda));
    }

    @PatchMapping("/{id}")
    public void atualizarVenda(@RequestBody AtualizacaoStatusDto status, @PathVariable("id") String idVenda){
        atualizarVendaInputPort.atualizar(idVenda, status.status(), status.motivo());
    }

    @GetMapping("/{id}")
    public VendaDto obterVenda(@PathVariable("id") String idVenda){
        return vendaMapper.toDto(buscarVendaInputPort.buscar(idVenda));
    }

}
