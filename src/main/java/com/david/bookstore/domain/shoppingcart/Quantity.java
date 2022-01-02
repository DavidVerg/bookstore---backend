package com.david.bookstore.domain.shoppingcart;

import java.util.Objects;

public class Quantity {

    private final int value;

    public Quantity(int value) {

        Objects.requireNonNull(value, "Quantity can not be null.");

        if (value < 0) {
            throw new IllegalArgumentException("Quantity can not be less than 0");
        }

        this.value = value;
    }

    public int asInt() {
        return value;
    }
}
