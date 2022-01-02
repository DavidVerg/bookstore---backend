package com.david.bookstore.domain.shoppingcart;

import java.math.BigDecimal;
import java.util.Objects;

public class TotalPrice {

    private final BigDecimal value;

    public TotalPrice(BigDecimal value) {

        Objects.requireNonNull(value, "Total price can not be null.");

        if(value.compareTo(BigDecimal.ZERO) < 1) {
            throw new IllegalArgumentException("Total price can not be 0 or less than 0.");
        }

        this.value = value;
    }

    public BigDecimal asBigDecimal() {
        return value;
    }

}
