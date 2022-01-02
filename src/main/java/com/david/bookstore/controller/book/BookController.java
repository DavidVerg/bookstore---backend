package com.david.bookstore.controller.book;

import com.david.bookstore.domain.book.*;
import com.david.bookstore.model.book.CreateBookInput;
import com.david.bookstore.model.book.CreateBookOutput;
import com.david.bookstore.model.book.UpdateBookInput;
import com.david.bookstore.model.book.UpdateBookOutput;
import com.david.bookstore.service.book.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAll() {
        List<Book> books = service.getAll();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getById(@PathVariable("id") String id) {
        final BookId bookId = BookId.fromString(id);
        Book book = service.getById(bookId);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping("/author/{author}")
    public ResponseEntity<List<Book>> getByAuthor(@PathVariable("author") BookAuthor bookAuthor) {
        List<Book> books = service.getByAuthor(bookAuthor);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Book>> getByCategory(@PathVariable("category") BookCategory bookCategory) {
        List<Book> books = service.getByCategory(bookCategory);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CreateBookOutput> create(@RequestBody CreateBookInput input) {

        BookId bookId = BookId.random();
        BookCover bookCover = new BookCover(input.getBookCover());
        BookName bookName = new BookName(input.getBookName());
        BookAuthor bookAuthor = new BookAuthor(input.getBookAuthor());
        LocalDate bookPublicationDate = input.getBookPublicationDate();
        BookSynopsis bookSynopsis = new BookSynopsis(input.getBookSynopsis());
        BookCategory bookCategory = new BookCategory(input.getBookCategory());
        BookPrice bookPrice = new BookPrice(input.getBookPrice());

        Book book = new Book(bookId,
                bookCover,
                bookName,
                bookAuthor,
                bookPublicationDate,
                bookSynopsis,
                bookCategory,
                bookPrice);

        Book createdBook = service.create(book);

        CreateBookOutput output = new CreateBookOutput(createdBook);

        return  new ResponseEntity<>(output, HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateBookOutput> update(@PathVariable("id") String id, @RequestBody UpdateBookInput input) {

        final BookId bookId = BookId.fromString(id);

        BookCover bookCover = new BookCover(input.getBookCover());
        BookName bookName = new BookName(input.getBookName());
        BookAuthor bookAuthor = new BookAuthor(input.getBookAuthor());
        LocalDate bookPublicationDate = input.getBookPublicationDate();
        BookSynopsis bookSynopsis = new BookSynopsis(input.getBookSynopsis());
        BookCategory bookCategory = new BookCategory(input.getBookCategory());
        BookPrice bookPrice = new BookPrice(input.getBookPrice());

        Book book = new Book(bookId,
                bookCover,
                bookName,
                bookAuthor,
                bookPublicationDate,
                bookSynopsis,
                bookCategory,
                bookPrice);

        Book updatedBook = service.update(bookId, book);

        UpdateBookOutput output = new UpdateBookOutput(updatedBook);

        return  new ResponseEntity<>(output, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") String id) {
        final BookId bookId = BookId.fromString(id);
        service.delete(bookId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
