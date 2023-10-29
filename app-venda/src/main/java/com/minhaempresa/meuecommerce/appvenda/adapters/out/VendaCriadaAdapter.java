package com.minhaempresa.meuecommerce.appvenda.adapters.out;

import com.minhaempresa.meuecommerce.appvenda.adapters.VendaMapper;
import com.minhaempresa.meuecommerce.appvenda.adapters.out.feign.OrquestradorClient;
import com.minhaempresa.meuecommerce.appvenda.application.domain.Venda;
import com.minhaempresa.meuecommerce.appvenda.application.ports.out.VendaCriadaEventPort;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("vendaCriadaAdapter")
public class VendaCriadaAdapter implements VendaCriadaEventPort {

    @Autowired
    private OrquestradorClient orquestradorClient;

    @Autowired
    private VendaMapper vendaMapper;

    @Override
    //@CircuitBreaker(name="vendaCriada", fallbackMethod = "vendaCriadaFallback")
    @Retry(name="vendaCriada", fallbackMethod = "vendaCriadaFallback")
    public void vendaCriada(Venda venda) {
        System.out.println("fechado");
        var vendaDto = vendaMapper.toDto(venda);
        orquestradorClient.criarVenda(vendaDto);
    }

    public void vendaCriadaFallback(Venda venda, Exception e) {
        System.out.println("rollback");
    }

}
