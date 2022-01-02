package com.david.bookstore.domain.book;

import com.david.bookstore.domain.book.BookCategory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BookCategoryTest {

    @Test
    @DisplayName("Book category should be valid")
    void validValueCheck() {
        // arrange
        String value = "Ciencia Ficcion, Aventura";

        // act
        BookCategory bookCategory = new BookCategory(value);


        // assert
        assertEquals(value, bookCategory.toString());
    }

    @Test
    @DisplayName("Book category null throws an error")
    void nullValueCheck() {
        // arrange
        String value = null;

        // act
        Executable executable = () -> new BookCategory(value);


        // assert
        assertThrows(NullPointerException.class, executable);
    }

    @Test
    @DisplayName("Empty book category throws an error")
    void emptyValueCheck() {
        // arrange
        String value = "";

        // act
        Executable executable = () -> new BookCategory(value);


        // assert
        assertThrows(IllegalArgumentException.class, executable);
    }

    @Test
    @DisplayName("Invalid book category throws an error")
    void invalidValueCheck() {
        // arrange
        String value = "Cienci@";

        // act
        Executable executable = () -> new BookCategory(value);


        // assert
        assertThrows(IllegalArgumentException.class, executable);
    }
}
