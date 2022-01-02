package com.david.bookstore.domain.book;

import com.david.bookstore.domain.book.BookCover;
import com.david.bookstore.domain.book.BookSynopsis;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BookSynopsisTest {

    @Test
    @DisplayName("Book synopsis should be valid")
    void validValueCheck() {
        // arrange
        String value = "La vida de Rand Al’Thor y sus amigos en Campo de Emond ha resultado bastante monótona.";

        // act
        BookSynopsis bookSynopsis = new BookSynopsis(value);


        // assert
        assertEquals(value, bookSynopsis.toString());
    }

    @Test
    @DisplayName("Book synopsis null throws an error")
    void nullValueCheck() {
        // arrange
        String value = null;

        // act
        Executable executable = () -> new BookSynopsis(value);


        // assert
        assertThrows(NullPointerException.class, executable);
    }

    @Test
    @DisplayName("Empty synopsis author throws an error")
    void emptyValueCheck() {
        // arrange
        String value = "";

        // act
        Executable executable = () -> new BookSynopsis(value);


        // assert
        assertThrows(IllegalArgumentException.class, executable);
    }

}
