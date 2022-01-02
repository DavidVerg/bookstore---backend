package com.david.bookstore.repository.book;

import com.david.bookstore.domain.book.Book;
import com.david.bookstore.domain.book.BookAuthor;
import com.david.bookstore.domain.book.BookCategory;
import com.david.bookstore.domain.book.BookId;

import java.util.List;

public interface BookRepository {

    List<Book> getAll();

    Book getById(BookId bookId);

    List<Book> getByAuthor(BookAuthor bookAuthor);

    List<Book> getByCategory(BookCategory bookCategory);

    void create(Book book);

    void update(BookId bookId, Book book);

    void delete(BookId bookId);

}
