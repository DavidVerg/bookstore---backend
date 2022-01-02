package com.david.bookstore.service.shoppingcart;

import com.david.bookstore.domain.book.Book;
import com.david.bookstore.domain.shoppingcart.*;
import com.david.bookstore.repository.book.BookRepository;
import com.david.bookstore.repository.shoppingcart.ShoppingCartRepository;
import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class ShoppingCartService {

    private final BookRepository bookRepository;
    private final ShoppingCartRepository repository;

    public ShoppingCartService(BookRepository bookRepository, ShoppingCartRepository repository) {
        this.bookRepository = bookRepository;
        this.repository = repository;
    }

    public List<ShoppingCart> getAll() {
        return repository.getAll();
    }

    public ShoppingCart getById(UserId userId) {
        return repository.getById(userId);
    }

    public ShoppingCart create(ShoppingCart shoppingCart) {
        repository.create(shoppingCart);
        return repository.getById(shoppingCart.getUserId());
    }

    public ShoppingCart createBookCartElement(UserId userId, LocalDate lastUpdateDate, BookCartElement bookCartElement) {

        if (repository.getByUserBookId(userId, bookCartElement) == null
            && validateCreate(userId, bookCartElement)) {
            repository.createBookCartElement(userId, bookCartElement);
        }

        TotalPrice totalPrice = new TotalPrice(getTotalPrice(repository.getById(userId).getBookCart()));
        repository.update(userId, lastUpdateDate, totalPrice);


        return repository.getById(userId);
    }

    public ShoppingCart update(UserId userId, LocalDate lastUpdateDate, BookCartElement bookCartElement) {

        if (bookCartElement.getQuantity().asInt() == 0) {
            repository.delete(userId, bookCartElement);
        }

        if (repository.getByUserBookId(userId, bookCartElement) != null
                && bookCartElement.getQuantity().asInt() != 0
                && validateUpdate(repository.getById(userId).getBookCart(), bookCartElement)) {
            repository.updateBookList(userId, bookCartElement);
        }

        TotalPrice totalPrice = new TotalPrice(getTotalPrice(repository.getById(userId).getBookCart()));
        repository.update(userId, lastUpdateDate, totalPrice);

        return repository.getById(userId);
    }



    private BigDecimal getTotalPrice(List<BookCartElement> bookCartElements) {

        BigDecimal value = BigDecimal.ZERO;

        for (BookCartElement bookCartElement : bookCartElements) {
            Book book = bookRepository.getById(bookCartElement.getBookId());
            value = value.add(book.getBookPrice().asBigDecimal().multiply(BigDecimal.valueOf(bookCartElement.getQuantity().asInt())));

        }

        BigDecimal accumDiscount = BigDecimal.ZERO;

        int i = 0;
        int count = 0;

        while (accumDiscount.compareTo(BigDecimal.valueOf(0.3)) < 0 && i < bookCartElements.size()) {
            count = bookCartElements.get(i).getQuantity().asInt();
            while (count >= 3 && accumDiscount.compareTo(BigDecimal.valueOf(0.3)) < 0) {
                accumDiscount = accumDiscount.add(BigDecimal.valueOf(0.1));
                count -= 3;
            }
            i++;
        }

        value = value.multiply(BigDecimal.valueOf(1).subtract(accumDiscount));

        if (value.compareTo(BigDecimal.valueOf(500)) > 0) {
            value = value.multiply(BigDecimal.valueOf(0.9));
        }

        return value;
    }

    private boolean validateCreate(UserId userId, BookCartElement bookCartElement) {

        List<Integer> quantities = getQuantities(repository.getById(userId).getBookCart());
        int countNormal = quantities.get(0);
        int countExpensive = quantities.get(1);

        RangeMap<BigDecimal, String> rangeMap = TreeRangeMap.create();

        rangeMap.put(Range.openClosed(BigDecimal.valueOf(0), BigDecimal.valueOf(50)), "cheap");
        rangeMap.put(Range.openClosed(BigDecimal.valueOf(50), BigDecimal.valueOf(199)), "normal");
        rangeMap.put(Range.open(BigDecimal.valueOf(199), BigDecimal.valueOf(1000)), "expensive");

        if (rangeMap.get(bookRepository.getById(bookCartElement.getBookId()).getBookPrice().asBigDecimal()).equals("normal")) {
            countNormal += bookCartElement.getQuantity().asInt();
        }

        if (rangeMap.get(bookRepository.getById(bookCartElement.getBookId()).getBookPrice().asBigDecimal()).equals("expensive")) {
            countExpensive += bookCartElement.getQuantity().asInt();;
        }

        if (countNormal < 11 && countExpensive < 2) {
            return true;
        };

        return false;
    }

    private boolean validateUpdate(List<BookCartElement> bookCartElements, BookCartElement bookCartElementNew) {

        int normalMovDir = 0;
        int expensiveMovDir = 0;

        RangeMap<BigDecimal, String> rangeMap = TreeRangeMap.create();

        rangeMap.put(Range.openClosed(BigDecimal.valueOf(0), BigDecimal.valueOf(50)), "cheap");
        rangeMap.put(Range.openClosed(BigDecimal.valueOf(50), BigDecimal.valueOf(199)), "normal");
        rangeMap.put(Range.open(BigDecimal.valueOf(199), BigDecimal.valueOf(1000)), "expensive");

        BookCartElement bookCartElementOld = bookCartElements.stream()
                .filter(e -> e.getBookId().toString().equals(bookCartElementNew.getBookId().toString()))
                .findFirst()
                .get();

        Book book = bookRepository.getById(bookCartElementNew.getBookId());

        if (rangeMap.get(book.getBookPrice().asBigDecimal()).equals("normal")) {
            normalMovDir = bookCartElementNew.getQuantity().asInt() - bookCartElementOld.getQuantity().asInt();
        }
        if (rangeMap.get(book.getBookPrice().asBigDecimal()).equals("expensive")) {
            expensiveMovDir = bookCartElementNew.getQuantity().asInt() - bookCartElementOld.getQuantity().asInt();
        }

        List<Integer> list = getQuantities(bookCartElements);
        return list.get(0) + normalMovDir <= 10 && list.get(1) + expensiveMovDir <= 1;
    }

    private List<Integer> getQuantities(List<BookCartElement> bookCartElements) {

        int countNormal = 0;
        int countExpensive = 0;

        RangeMap<BigDecimal, String> rangeMap = TreeRangeMap.create();

        rangeMap.put(Range.openClosed(BigDecimal.valueOf(0), BigDecimal.valueOf(50)), "cheap");
        rangeMap.put(Range.openClosed(BigDecimal.valueOf(50), BigDecimal.valueOf(199)), "normal");
        rangeMap.put(Range.open(BigDecimal.valueOf(199), BigDecimal.valueOf(1000)), "expensive");

        for (BookCartElement bookCartElement : bookCartElements) {
            Book book = bookRepository.getById(bookCartElement.getBookId());
            if (rangeMap.get(book.getBookPrice().asBigDecimal()).equals("normal")) {
                countNormal += bookCartElement.getQuantity().asInt();
            }
            if (rangeMap.get(book.getBookPrice().asBigDecimal()).equals("expensive")) {
                countExpensive += bookCartElement.getQuantity().asInt();
            }
        }

        return Arrays.asList(countNormal, countExpensive);
    }

}