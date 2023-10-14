package com.minhaempresa.meuecommerce.service;

import com.minhaempresa.meuecommerce.model.Pedido;
import org.springframework.stereotype.Service;

@Service
public class FraudeService {

    public boolean verificarPossivelFraude(Pedido pedido) {

        if(pedido.getValorTotal() < 1000) {
            return false;
        }
        return true;
    }
}
