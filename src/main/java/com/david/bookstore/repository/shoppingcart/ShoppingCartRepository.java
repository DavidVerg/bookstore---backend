package com.david.bookstore.repository.shoppingcart;

import com.david.bookstore.domain.shoppingcart.BookCartElement;
import com.david.bookstore.domain.shoppingcart.ShoppingCart;
import com.david.bookstore.domain.shoppingcart.TotalPrice;
import com.david.bookstore.domain.shoppingcart.UserId;
import org.apache.tomcat.jni.User;

import java.time.LocalDate;
import java.util.List;

public interface ShoppingCartRepository {

    List<ShoppingCart> getAll();

    ShoppingCart getById(UserId userId);

    BookCartElement getByUserBookId(UserId userId, BookCartElement bookCartElement);

    //List<Book> getByAuthor(BookAuthor bookAuthor);

    //List<Book> getByCategory(BookCategory bookCategory);



    void create(ShoppingCart shoppingCart);

    void createBookCartElement(UserId userId, BookCartElement bookCartElement);

    void update(UserId userId, LocalDate lastUpdateDate, TotalPrice totalPrice);

    void updateBookList(UserId userId, BookCartElement bookCartElement);

    void delete(UserId userid, BookCartElement bookCartElement);

}
