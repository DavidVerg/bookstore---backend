package com.david.bookstore.model.book;

import com.david.bookstore.domain.book.Book;

public class UpdateBookOutput {

    private Book book;

    public UpdateBookOutput() {
    }

    public UpdateBookOutput(Book book) {
        this.book = book;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

}
