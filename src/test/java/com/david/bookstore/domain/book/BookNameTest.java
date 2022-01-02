package com.david.bookstore.domain.book;

import com.david.bookstore.domain.book.BookCover;
import com.david.bookstore.domain.book.BookName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BookNameTest {

    @Test
    @DisplayName("Book name should be valid")
    void validValueCheck() {
        // arrange
        String value = "Harry Potter";

        // act
        BookName bookName = new BookName(value);


        // assert
        assertEquals(value, bookName.toString());
    }

    @Test
    @DisplayName("Book name null throws an error")
    void nullValueCheck() {
        // arrange
        String value = null;

        // act
        Executable executable = () -> new BookName(value);


        // assert
        assertThrows(NullPointerException.class, executable);
    }

    @Test
    @DisplayName("Empty book name throws an error")
    void emptyValueCheck() {
        // arrange
        String value = "";

        // act
        Executable executable = () -> new BookName(value);


        // assert
        assertThrows(IllegalArgumentException.class, executable);
    }

}
