package com.david.bookstore.domain.shoppingcart;

import java.util.Objects;
import java.util.UUID;

public class UserId {

    private final UUID value;

    public UserId(UUID value) {

        Objects.requireNonNull(value, "User id can not be null.");

        this.value = value;
    }

    public static UserId fromString(String unsafeValue) {
        return new UserId(UUID.fromString(unsafeValue));
    }

    public static UserId random() {
        return new UserId(UUID.randomUUID());
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
