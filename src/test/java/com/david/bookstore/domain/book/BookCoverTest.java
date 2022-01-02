package com.david.bookstore.domain.book;

import com.david.bookstore.domain.book.BookAuthor;
import com.david.bookstore.domain.book.BookCover;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BookCoverTest {

    @Test
    @DisplayName("Book cover should be valid")
    void validValueCheck() {
        // arrange
        String value = "https://m.media-amazon.com/images/I/4172G5zjtbL.jpg";

        // act
        BookCover bookCover = new BookCover(value);


        // assert
        assertEquals(value, bookCover.toString());
    }

    @Test
    @DisplayName("Book author null throws an error")
    void nullValueCheck() {
        // arrange
        String value = null;

        // act
        Executable executable = () -> new BookCover(value);


        // assert
        assertThrows(NullPointerException.class, executable);
    }

    @Test
    @DisplayName("Empty book author throws an error")
    void emptyValueCheck() {
        // arrange
        String value = "";

        // act
        Executable executable = () -> new BookCover(value);


        // assert
        assertThrows(IllegalArgumentException.class, executable);
    }
}
