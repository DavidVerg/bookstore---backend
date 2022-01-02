package com.david.bookstore.configuration.jackson.codecs.shoppingcart;

import com.david.bookstore.domain.book.BookPrice;
import com.david.bookstore.domain.shoppingcart.TotalPrice;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.math.BigDecimal;

public class TotalPriceParser {

    public static class Serializer extends JsonSerializer<TotalPrice> {

        @Override
        public void serialize(TotalPrice value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            BigDecimal price = value.asBigDecimal();
            gen.writeNumber(price);
        }
    }

    public static class Deserializer extends JsonDeserializer<TotalPrice> {

        @Override
        public TotalPrice deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
            BigDecimal valueAsDecimal = p.getDecimalValue();
            return new TotalPrice(valueAsDecimal);
        }
    }

}
