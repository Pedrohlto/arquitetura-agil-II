package com.minhaempresa.meuecommerce.orquestrador.clients;

import com.minhaempresa.meuecommerce.orquestrador.dto.pagamento.PagamentoRequestDto;
import com.minhaempresa.meuecommerce.orquestrador.dto.pagamento.RespostaPagamentoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="Pagamento", url="http://localhost:8081")
public interface PagamentoClient {

    @PostMapping(consumes = "application/json")
    RespostaPagamentoDto cobrarCartao(@RequestBody PagamentoRequestDto cobrancaCartaoDto);

}
