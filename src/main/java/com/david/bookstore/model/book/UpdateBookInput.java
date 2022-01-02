package com.david.bookstore.model.book;

import com.david.bookstore.domain.book.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class UpdateBookInput {

    private String bookCover;
    private String bookName;
    private String bookAuthor;
    private LocalDate bookPublicationDate;
    private String bookSynopsis;
    private String bookCategory;
    private BigDecimal bookPrice;

    public UpdateBookInput() {
    }

    public UpdateBookInput(String bookCover, String bookName, String bookAuthor, LocalDate bookPublicationDate, String bookSynopsis, String bookCategory, BigDecimal bookPrice) {
        this.bookCover = bookCover;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPublicationDate = bookPublicationDate;
        this.bookSynopsis = bookSynopsis;
        this.bookCategory = bookCategory;
        this.bookPrice = bookPrice;
    }

    public String getBookCover() {
        return bookCover;
    }

    public void setBookCover(String bookCover) {
        this.bookCover = bookCover;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public LocalDate getBookPublicationDate() {
        return bookPublicationDate;
    }

    public void setBookPublicationDate(LocalDate bookPublicationDate) {
        this.bookPublicationDate = bookPublicationDate;
    }

    public String getBookSynopsis() {
        return bookSynopsis;
    }

    public void setBookSynopsis(String bookSynopsis) {
        this.bookSynopsis = bookSynopsis;
    }

    public String getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }

    public BigDecimal getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(BigDecimal bookPrice) {
        this.bookPrice = bookPrice;
    }
}
