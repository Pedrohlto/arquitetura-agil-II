package com.minhaempresa.meuecommerce.appestoque.adapters.in;


import com.minhaempresa.meuecommerce.appestoque.adapters.dtos.ReservaDto;
import com.minhaempresa.meuecommerce.appestoque.application.ports.in.ReservaProdutoInputPort;
import com.minhaempresa.meuecommerce.appestoque.application.utils.ReservaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaProdutoInputPort reservaProdutoInputPort;

    @Autowired
    private ReservaMapper reservaMapper;

    @PostMapping
    public ReservaDto reservar(@RequestBody ReservaDto reservaDto) {
        var reservaCriada = reservaProdutoInputPort.reservar(reservaMapper.toDomain(reservaDto));
        return reservaMapper.toDto(reservaCriada);
    }
}
