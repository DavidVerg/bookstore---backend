package com.david.bookstore.domain.book;

import java.util.Objects;

public class BookName {


    private final String value;

    public BookName(String value) {

        Objects.requireNonNull(value, "Book name can not be null.");

        String trimmedValue = value.trim();

        if (trimmedValue.length() == 0) {
            throw new IllegalArgumentException("Book name can not be empty.");
        }

        this.value = trimmedValue;
    }

    @Override
    public String toString() {
        return value;
    }
}