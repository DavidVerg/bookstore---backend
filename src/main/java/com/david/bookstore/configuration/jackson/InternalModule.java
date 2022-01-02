package com.david.bookstore.configuration.jackson;

import com.david.bookstore.configuration.jackson.codecs.book.*;
import com.david.bookstore.configuration.jackson.codecs.shoppingcart.QuantityParser;
import com.david.bookstore.configuration.jackson.codecs.shoppingcart.TotalPriceParser;
import com.david.bookstore.configuration.jackson.codecs.shoppingcart.UserIdParser;
import com.david.bookstore.domain.book.*;
import com.david.bookstore.domain.shoppingcart.Quantity;
import com.david.bookstore.domain.shoppingcart.TotalPrice;
import com.david.bookstore.domain.shoppingcart.UserId;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class InternalModule extends SimpleModule {

    private static final String NAME = "InternalModule";

    public InternalModule() {
        super(NAME, Version.unknownVersion());

        //Book

        addSerializer(BookId.class, new BookIdParser.Serializer());
        addDeserializer(BookId.class, new BookIdParser.Deserializer());

        addSerializer(BookCover.class, new BookCoverParser.Serializer());
        addDeserializer(BookCover.class, new BookCoverParser.Deserializer());

        addSerializer(BookName.class, new BookNameParser.Serializer());
        addDeserializer(BookName.class, new BookNameParser.Deserializer());

        addSerializer(BookAuthor.class, new BookAuthorParser.Serializer());
        addDeserializer(BookAuthor.class, new BookAuthorParser.Deserializer());

        addSerializer(BookSynopsis.class, new BookSynopsisParser.Serializer());
        addDeserializer(BookSynopsis.class, new BookSynopsisParser.Deserializer());

        addSerializer(BookCategory.class, new BookCategoryParser.Serializer());
        addDeserializer(BookCategory.class, new BookCategoryParser.Deserializer());

        addSerializer(BookPrice.class, new BookPriceParser.Serializer());
        addDeserializer(BookPrice.class, new BookPriceParser.Deserializer());

        //Shopping Cart

        addSerializer(UserId.class, new UserIdParser.Serializer());
        addDeserializer(UserId.class, new UserIdParser.Deserializer());

        addSerializer(TotalPrice.class, new TotalPriceParser.Serializer());
        addDeserializer(TotalPrice.class, new TotalPriceParser.Deserializer());

        addSerializer(Quantity.class, new QuantityParser.Serializer());
        addDeserializer(Quantity.class, new QuantityParser.Deserializer());

    }
}