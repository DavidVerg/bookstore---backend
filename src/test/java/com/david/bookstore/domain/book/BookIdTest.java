package com.david.bookstore.domain.book;

import com.david.bookstore.domain.book.BookCover;
import com.david.bookstore.domain.book.BookId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BookIdTest {

    @Test
    @DisplayName("Book id should be valid")
    void validValueCheck() {
        // arrange
        String value = "6306194e-6b53-11ec-90d6-0242ac120003";

        // act
        BookId bookId = BookId.fromString("6306194e-6b53-11ec-90d6-0242ac120003");

        // assert
        assertEquals(value, bookId.toString());
    }

}
