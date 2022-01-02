package com.david.bookstore.domain.book;

import java.util.Objects;
import java.util.regex.Pattern;

public class BookSynopsis {

    //private static final Pattern pattern = Pattern.compile("");

    private final String value;

    public BookSynopsis(String value) {

        Objects.requireNonNull(value, "Book synopsis can not be null.");

        String trimmedValue = value.trim();

        if (trimmedValue.length() == 0) {
            throw new IllegalArgumentException("Product synopsis can not be empty.");
        }

        //boolean isValid = pattern.matcher(trimmedValue).matches();

        //if (!isValid) {
        //    throw new IllegalArgumentException("Invalid book synopsis.");
        //}

        this.value = trimmedValue;
    }

    @Override
    public String toString() {
        return value;
    }

}
