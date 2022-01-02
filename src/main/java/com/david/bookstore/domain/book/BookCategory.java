package com.david.bookstore.domain.book;

import java.util.Objects;
import java.util.regex.Pattern;

public class BookCategory {

    private static final Pattern pattern = Pattern.compile("^[a-zA-Z ,]+$");

    private final String value;

    public BookCategory(String value) {

        Objects.requireNonNull(value, "Book category can not be null.");

        String trimmedValue = value.trim();

        if (trimmedValue.length() == 0) {
            throw new IllegalArgumentException("Book category can not be empty.");
        }

        boolean isValid = pattern.matcher(trimmedValue).matches();

        if (!isValid) {
            throw new IllegalArgumentException("Invalid book category.");
        }

        this.value = trimmedValue;
    }

    @Override
    public String toString() {
        return value;
    }
}
