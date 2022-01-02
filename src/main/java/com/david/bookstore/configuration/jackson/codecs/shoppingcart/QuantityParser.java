package com.david.bookstore.configuration.jackson.codecs.shoppingcart;

import com.david.bookstore.domain.shoppingcart.Quantity;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class QuantityParser {

    public static class Serializer extends JsonSerializer<Quantity> {

        @Override
        public void serialize(Quantity value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            Integer number = value.asInt();
            gen.writeNumber(number);
        }
    }

    public static class Deserializer extends JsonDeserializer<Quantity> {
        @Override
        public Quantity deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
            int valueAsInt = p.getValueAsInt();
            return new Quantity(valueAsInt);
        }
    }

}
