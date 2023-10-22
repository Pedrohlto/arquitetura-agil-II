package com.minhaempresa.meuecommerce.appvenda.config.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.minhaempresa.meuecommerce.appvenda.adapters.event.VendaEvent;
import org.apache.kafka.common.serialization.Deserializer;


public class CustomDeserializerKafka implements Deserializer<VendaEvent> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public VendaEvent deserialize(String topic, byte[] data) {
        try {
            if (data == null){
                return null;
            }
            return objectMapper.readValue(new String(data, "UTF-8"), VendaEvent.class);
        } catch (Exception e) {
            //throw new SerializationException("Error when deserializing byte[] to SaleMessage");
            System.out.println("");
            return null;
        }
    }
}
