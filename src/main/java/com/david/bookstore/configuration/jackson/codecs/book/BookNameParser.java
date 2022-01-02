package com.david.bookstore.configuration.jackson.codecs.book;

import com.david.bookstore.domain.book.BookName;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class BookNameParser {

    public static class Serializer extends JsonSerializer<BookName> {

        @Override
        public void serialize(BookName value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString(value.toString());
        }
    }

    public static class Deserializer extends JsonDeserializer<BookName> {

        @Override
        public BookName deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
            return new BookName(p.getValueAsString());
        }
    }

}
