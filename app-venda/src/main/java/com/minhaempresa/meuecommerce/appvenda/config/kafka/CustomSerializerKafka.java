package com.minhaempresa.meuecommerce.appvenda.config.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.minhaempresa.meuecommerce.appvenda.adapters.event.VendaEvent;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

public class CustomSerializerKafka implements Serializer<VendaEvent> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public byte[] serialize(String s, VendaEvent saleMessage) {
        try {
            if (saleMessage == null){
                return null;
            }
            return objectMapper.writeValueAsBytes(saleMessage);
        } catch (Exception e) {
            throw new SerializationException("Error when serializing SaleMessage to byte[]");
        }
    }


}
