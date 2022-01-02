package com.david.bookstore.domain.shoppingcart;

import com.david.bookstore.domain.book.*;

import java.time.LocalDate;
import java.util.List;


public class ShoppingCart {

    private final UserId userId;
    private final LocalDate creationDate;
    private final LocalDate lastUpdateDate;
    private final List<BookCartElement> bookCart;
    private final TotalPrice totalPrice;

    public ShoppingCart(UserId userId, LocalDate creationDate, LocalDate lastUpdateDate, List<BookCartElement> bookCart, TotalPrice totalPrice) {
        this.userId = userId;
        this.creationDate = creationDate;
        this.lastUpdateDate = lastUpdateDate;
        this.bookCart = bookCart;
        this.totalPrice = totalPrice;
    }

    public UserId getUserId() {
        return userId;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public LocalDate getLastUpdateDate() {
        return lastUpdateDate;
    }

    public List<BookCartElement> getBookCart() {
        return bookCart;
    }

    public TotalPrice getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "userId=" + userId +
                ", creationDate=" + creationDate +
                ", lastUpdateDate=" + lastUpdateDate +
                ", bookCart=" + bookCart +
                ", totalPrice=" + totalPrice +
                '}';
    }
}