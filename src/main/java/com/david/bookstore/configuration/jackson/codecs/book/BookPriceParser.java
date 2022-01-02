package com.david.bookstore.configuration.jackson.codecs.book;

import com.david.bookstore.domain.book.BookPrice;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.math.BigDecimal;

public class BookPriceParser {

    public static class Serializer extends JsonSerializer<BookPrice> {

        @Override
        public void serialize(BookPrice value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            BigDecimal price = value.asBigDecimal();
            gen.writeNumber(price);
        }
    }

    public static class Deserializer extends JsonDeserializer<BookPrice> {

        @Override
        public BookPrice deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
            BigDecimal valueAsDecimal = p.getDecimalValue();
            return new BookPrice(valueAsDecimal);
        }
    }

}
