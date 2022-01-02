package com.david.bookstore.service.book;

import com.david.bookstore.domain.book.Book;
import com.david.bookstore.domain.book.BookAuthor;
import com.david.bookstore.domain.book.BookCategory;
import com.david.bookstore.domain.book.BookId;
import com.david.bookstore.repository.book.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public List<Book> getAll() {
        return repository.getAll();
    }

    public Book getById(BookId bookId) {
        return repository.getById(bookId);
    }

    public List<Book> getByAuthor(BookAuthor bookAuthor) {
        return repository.getByAuthor(bookAuthor);
    }

    public List<Book> getByCategory(BookCategory bookCategory) {
        return repository.getByCategory(bookCategory);
    }

    public Book create(Book book) {
        repository.create(book);
        return repository.getById(book.getBookId());
    }

    public Book update(BookId bookId, Book book) {
        repository.update(bookId, book);
        return repository.getById(bookId);
    }

    public void delete(BookId bookId) {
        repository.delete(bookId);
    }

}
