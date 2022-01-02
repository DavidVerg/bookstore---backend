package com.david.bookstore.domain.shoppingcart;

import com.david.bookstore.domain.book.BookPrice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TotalPriceTest {

    @Test
    @DisplayName("Value should be valid")
    void validValueCheck() {
        // arrange
        BigDecimal value = BigDecimal.valueOf(50);

        // act
        TotalPrice totalPrice = new TotalPrice(value);


        // assert
        assertEquals(value, totalPrice.asBigDecimal());
    }

    @Test
    @DisplayName("Total price null throws an error")
    void nullCheck() {
        // arrange
        BigDecimal value = null;

        // act
        Executable executable = () -> new TotalPrice(value);


        // assert
        assertThrows(NullPointerException.class, executable);
    }

    @Test
    @DisplayName("Invalid total price throws an error")
    void illegalValueCheck() {
        // arrange
        BigDecimal value = BigDecimal.valueOf(0);

        // act
        Executable executable = () -> new TotalPrice(value);


        // assert
        assertThrows(IllegalArgumentException.class, executable);
    }

}
