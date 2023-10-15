package com.minhaempresa.meuecommerce.orquestrador.dto.pagamento;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class DadosPagamentoRequest {

    @JsonProperty("numero_cartao")
    private String numeroCartao;

    @JsonProperty("nome_titular")
    private String nomeTitular;

    @JsonProperty("data_validade")
    private String dataValidade;

    @JsonProperty("codigo_seguranca")
    private String codigoSeguranca;

}
