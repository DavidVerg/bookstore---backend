package com.david.bookstore.configuration.jackson.codecs.book;

import com.david.bookstore.domain.book.BookCategory;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class BookCategoryParser {

    public static class Serializer extends JsonSerializer<BookCategory> {

        @Override
        public void serialize(BookCategory value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString(value.toString());
        }
    }

    public static class Deserializer extends JsonDeserializer<BookCategory> {

        @Override
        public BookCategory deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
            return new BookCategory(p.getValueAsString());
        }
    }

}
