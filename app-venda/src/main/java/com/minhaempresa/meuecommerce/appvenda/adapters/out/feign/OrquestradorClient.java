package com.minhaempresa.meuecommerce.appvenda.adapters.out.feign;


import com.minhaempresa.meuecommerce.appvenda.adapters.dto.VendaDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "orquestrador", url = "http://localhost:8084")
public interface OrquestradorClient {

    @RequestMapping(method = RequestMethod.POST, value = "/orquestracao")
    VendaDto criarVenda(@RequestBody VendaDto vendaCriadaDTO);

}
