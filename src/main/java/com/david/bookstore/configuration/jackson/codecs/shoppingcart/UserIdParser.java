package com.david.bookstore.configuration.jackson.codecs.shoppingcart;

import com.david.bookstore.domain.book.BookId;
import com.david.bookstore.domain.shoppingcart.UserId;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class UserIdParser {

    public static  class Serializer extends JsonSerializer<UserId> {

        @Override
        public void serialize(UserId value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
            gen.writeString(value.toString());
        }
    }

    public static  class Deserializer extends JsonDeserializer<UserId> {

        @Override
        public UserId deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
            return UserId.fromString(p.getValueAsString());
        }
    }

}
