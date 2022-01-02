package com.david.bookstore.domain.book;

import java.util.Objects;
import java.util.regex.Pattern;

public class BookCover {

    private final String value;

    public BookCover(String value) {

        Objects.requireNonNull(value, "Book cover url can not be null.");

        String trimmedValue = value.trim();

        if (trimmedValue.length() == 0) {
            throw new IllegalArgumentException("Book cover url can not be empty.");
        }

        this.value = trimmedValue;
    }

    @Override
    public String toString() {
        return value;
    }
}
