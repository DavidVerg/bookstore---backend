package com.david.bookstore.model.book;

import com.david.bookstore.domain.book.Book;

public class CreateBookOutput {

    private Book book;

    public CreateBookOutput() {
    }

    public CreateBookOutput(Book book) {
        this.book = book;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
