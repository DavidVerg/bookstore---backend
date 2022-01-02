package com.david.bookstore.domain.book;

import java.util.Objects;
import java.util.UUID;

public class BookId {

    private final UUID value;

    public BookId(UUID value) {

        Objects.requireNonNull(value, "Book id can not be null.");

        this.value = value;
    }

    public static BookId fromString(String unsafeValue) {
        return new BookId(UUID.fromString(unsafeValue));
    }

    public static BookId random() {
        return new BookId(UUID.randomUUID());
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
