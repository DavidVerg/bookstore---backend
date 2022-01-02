package com.david.bookstore.domain.book;

import java.time.LocalDate;

public class Book {

    private final BookId bookId;
    private final BookCover bookCover;
    private final BookName bookName;
    private final BookAuthor bookAuthor;
    private final LocalDate bookPublicationDate;
    private final BookSynopsis bookSynopsis;
    private final BookCategory bookCategory;
    private final BookPrice bookPrice;

    public Book(BookId bookId, BookCover bookCover, BookName bookName, BookAuthor bookAuthor, LocalDate bookPublicationDate, BookSynopsis bookSynopsis, BookCategory bookCategory, BookPrice bookPrice) {
        this.bookId = bookId;
        this.bookCover = bookCover;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPublicationDate = bookPublicationDate;
        this.bookSynopsis = bookSynopsis;
        this.bookCategory = bookCategory;
        this.bookPrice = bookPrice;
    }

    public BookId getBookId() {
        return bookId;
    }

    public BookCover getBookCover() {
        return bookCover;
    }

    public BookName getBookName() {
        return bookName;
    }

    public BookAuthor getBookAuthor() {
        return bookAuthor;
    }

    public LocalDate getBookPublicationDate() {
        return bookPublicationDate;
    }

    public BookSynopsis getBookSynopsis() {
        return bookSynopsis;
    }

    public BookCategory getBookCategory() {
        return bookCategory;
    }

    public BookPrice getBookPrice() {
        return bookPrice;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookCover=" + bookCover +
                ", bookName=" + bookName +
                ", bookAuthor=" + bookAuthor +
                ", bookPublicationDate=" + bookPublicationDate +
                ", bookSynopsis=" + bookSynopsis +
                ", bookCategory=" + bookCategory +
                ", bookPrice=" + bookPrice +
                '}';
    }
}
