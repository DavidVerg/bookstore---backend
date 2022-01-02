package com.david.bookstore.controller.shoppingcart;

import com.david.bookstore.domain.book.*;
import com.david.bookstore.domain.shoppingcart.*;
import com.david.bookstore.model.book.CreateBookInput;
import com.david.bookstore.model.book.UpdateBookInput;
import com.david.bookstore.model.book.UpdateBookOutput;
import com.david.bookstore.model.shoppingcart.CreateShoppingCartOutput;
import com.david.bookstore.model.shoppingcart.UpdateShoppingCartInput;
import com.david.bookstore.model.shoppingcart.UpdateShoppingCartOutput;
import com.david.bookstore.service.shoppingcart.ShoppingCartService;
import org.apache.tomcat.jni.Local;
import org.apache.tomcat.jni.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/shopping-cart")
public class ShoppingCartController {

    private final ShoppingCartService service;

    public ShoppingCartController(ShoppingCartService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ShoppingCart>> getAll() {
        List<ShoppingCart> shoppingCarts = service.getAll();
        return new ResponseEntity<>(shoppingCarts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShoppingCart> getById(@PathVariable("id") String id) {
        final UserId userId = UserId.fromString(id);
        ShoppingCart shoppingCart = service.getById(userId);
        return new ResponseEntity<>(shoppingCart, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CreateShoppingCartOutput> create() {

        UserId userId = UserId.random();
        LocalDate creationDate = LocalDate.now();
        LocalDate lastUpdateDate = LocalDate.now();
        List<BookCartElement> bookCart = new ArrayList<>();
        TotalPrice totalPrice = new TotalPrice(BigDecimal.ZERO);

        ShoppingCart shoppingCart = new ShoppingCart(
                userId,
                creationDate,
                lastUpdateDate,
                bookCart,
                totalPrice
        );

        ShoppingCart createdShoppingCart = service.create(shoppingCart);

        CreateShoppingCartOutput output = new CreateShoppingCartOutput(createdShoppingCart);

        return  new ResponseEntity<>(output, HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<UpdateShoppingCartOutput> createBookCartElement(@PathVariable("id") String id, @RequestBody UpdateShoppingCartInput input) {

        final UserId userId = UserId.fromString(id);

        ShoppingCart shoppingCart = service.getById(userId);

        BookId bookId = BookId.fromString(input.getBookId());
        Quantity quantity = new Quantity(input.getQuantity());

        BookCartElement bookCartElement = new BookCartElement(
                bookId,
                quantity
        );
        LocalDate lastUpdateDate = LocalDate.now();

        ShoppingCart updatedShoppingCart = service.createBookCartElement(userId, lastUpdateDate, bookCartElement);

        UpdateShoppingCartOutput output = new UpdateShoppingCartOutput(updatedShoppingCart);

        return new ResponseEntity<>(output, HttpStatus.OK);

    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateShoppingCartOutput> update(@PathVariable("id") String id, @RequestBody UpdateShoppingCartInput input) {

        final UserId userId = UserId.fromString(id);

        ShoppingCart shoppingCart = service.getById(userId);

        BookId bookId = BookId.fromString(input.getBookId());
        Quantity quantity = new Quantity(input.getQuantity());

        BookCartElement bookCartElement = new BookCartElement(
                bookId,
                quantity
        );
        LocalDate lastUpdateDate = LocalDate.now();

        ShoppingCart updatedShoppingCart = service.update(userId, lastUpdateDate, bookCartElement);

        UpdateShoppingCartOutput output = new UpdateShoppingCartOutput(updatedShoppingCart);

        return new ResponseEntity<>(output, HttpStatus.OK);

    }
}
