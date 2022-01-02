package com.david.bookstore.domain.book;

import java.math.BigDecimal;
import java.util.Objects;

public class BookPrice {

    private final BigDecimal value;

    public BookPrice(BigDecimal value) {

        Objects.requireNonNull(value, "Book price can not be null.");

        if(value.compareTo(BigDecimal.ZERO) < 1) {
            throw new IllegalArgumentException("Book price can not be 0 or less than 0.");
        }

        this.value = value;
    }

    public BigDecimal asBigDecimal() {
        return value;
    }

}
