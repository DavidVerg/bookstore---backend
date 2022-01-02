package com.david.bookstore.domain.book;

import com.david.bookstore.domain.book.BookPrice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BookPriceTest {

    @Test
    @DisplayName("Value should be valid")
    void validValueCheck() {
        // arrange
        BigDecimal value = BigDecimal.valueOf(50);

        // act
        BookPrice bookPrice = new BookPrice(value);


        // assert
        assertEquals(value, bookPrice.asBigDecimal());
    }

    @Test
    @DisplayName("Book price null throws an error")
    void nullCheck() {
        // arrange
        BigDecimal value = null;

        // act
        Executable executable = () -> new BookPrice(value);


        // assert
        assertThrows(NullPointerException.class, executable);
    }

    @Test
    @DisplayName("Invalid book price throws an error")
    void illegalValueCheck() {
        // arrange
        BigDecimal value = BigDecimal.valueOf(0);

        // act
        Executable executable = () -> new BookPrice(value);


        // assert
        assertThrows(IllegalArgumentException.class, executable);
    }

}
