package com.david.bookstore.domain.shoppingcart;

import com.david.bookstore.domain.book.BookId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserIdTest {

    @Test
    @DisplayName("value should be valid")
    void validValueCheck() {
        // arrange
        String value = "6306194e-6b53-11ec-90d6-0242ac120003";

        // act
        UserId userId = UserId.fromString("6306194e-6b53-11ec-90d6-0242ac120003");

        // assert
        assertEquals(value, userId.toString());
    }

}
