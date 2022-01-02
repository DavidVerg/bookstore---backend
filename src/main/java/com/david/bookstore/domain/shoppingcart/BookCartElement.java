package com.david.bookstore.domain.shoppingcart;

import com.david.bookstore.domain.book.BookId;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class BookCartElement {

    private final BookId bookId;
    private final Quantity quantity;

    public BookCartElement(BookId bookId, Quantity quantity) {
        this.bookId = bookId;
        this.quantity = quantity;
    }

    public BookId getBookId() {
        return bookId;
    }

    public Quantity getQuantity() {
        return quantity;
    }

}
