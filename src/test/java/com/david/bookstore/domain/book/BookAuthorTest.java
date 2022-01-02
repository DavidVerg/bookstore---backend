package com.david.bookstore.domain.book;

import com.david.bookstore.domain.book.BookAuthor;
import com.david.bookstore.domain.book.BookPrice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BookAuthorTest {

    @Test
    @DisplayName("Book author should be valid")
    void validValueCheck() {
        // arrange
        String value = "David Alejandro Vergara";

        // act
        BookAuthor bookAuthor = new BookAuthor(value);


        // assert
        assertEquals(value, bookAuthor.toString());
    }

    @Test
    @DisplayName("Book author null throws an error")
    void nullValueCheck() {
        // arrange
        String value = null;

        // act
        Executable executable = () -> new BookAuthor(value);


        // assert
        assertThrows(NullPointerException.class, executable);
    }

    @Test
    @DisplayName("Empty book author throws an error")
    void emptyValueCheck() {
        // arrange
        String value = "";

        // act
        Executable executable = () -> new BookAuthor(value);


        // assert
        assertThrows(IllegalArgumentException.class, executable);
    }

    @Test
    @DisplayName("Invalid book author throws an error")
    void invalidValueCheck() {
        // arrange
        String value = "David123";

        // act
        Executable executable = () -> new BookAuthor(value);


        // assert
        assertThrows(IllegalArgumentException.class, executable);
    }
}
