package com.david.bookstore.repository.shoppingcart;

import com.david.bookstore.domain.book.*;
import com.david.bookstore.domain.shoppingcart.*;
import org.apache.tomcat.jni.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Repository
public class ShoppingCartRepositoryImplementation implements ShoppingCartRepository {

    private final JdbcTemplate jdbcTemplate;

    public ShoppingCartRepositoryImplementation(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<BookCartElement> bookListrowMapper = (resultset, rowNum) -> {

        BookId bookId = BookId.fromString(resultset.getString("book_id"));
        Quantity quantity = new Quantity(resultset.getInt("quantity"));

        return new BookCartElement(
                bookId,
                quantity
        );
    };

    public List<BookCartElement> getAllBooks(UserId userId) {
        String sqlQuery = "select * from book_list where user_id = ?";
        return jdbcTemplate.query(sqlQuery, bookListrowMapper, userId.toString());
    }

    private final RowMapper<ShoppingCart> rowMapper = (resultSet, rowNum) -> {

        UserId userId = UserId.fromString(resultSet.getString("user_id"));
        LocalDate creationDate = resultSet.getDate("creation_date").toLocalDate();
        LocalDate lastUpdateDate = resultSet.getDate("last_update_date").toLocalDate();
        TotalPrice totalPrice = new TotalPrice(resultSet.getBigDecimal("total_price"));
        List<BookCartElement> bookCartElements = getAllBooks(userId);

        return new ShoppingCart(
                userId,
                creationDate,
                lastUpdateDate,
                bookCartElements,
                totalPrice
        );
    };


    @Override
    public List<ShoppingCart> getAll() {
        String sqlQuery = "select * from shopping_cart";
        return jdbcTemplate.query(sqlQuery, rowMapper);
    }

    @Override
    public ShoppingCart getById(UserId userId) {
        String sqlQuery = "select * from shopping_cart where user_id = ?";
        return jdbcTemplate.queryForObject(sqlQuery, rowMapper, userId.toString());
    }

    @Override
    public BookCartElement getByUserBookId(UserId userId, BookCartElement bookCartElement) {
        String sqlQuery = "select * from book_list where user_id = ? and book_id = ?";
        try {
            return jdbcTemplate.queryForObject(sqlQuery, bookListrowMapper, userId.toString(), bookCartElement.getBookId().toString());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void create(ShoppingCart shoppingCart) {
        String sqlQuery = "insert into shopping_cart(user_id, creation_date, last_update_date, total_price) values(?, ?, ?, ?)";
        jdbcTemplate.update(sqlQuery, ps -> {
            ps.setString(1, shoppingCart.getUserId().toString());
            ps.setDate(2, Date.valueOf(shoppingCart.getCreationDate()));
            ps.setDate(3, Date.valueOf(shoppingCart.getLastUpdateDate()));
            ps.setBigDecimal(4, shoppingCart.getTotalPrice().asBigDecimal());
        });
    }

    @Override
    public void createBookCartElement(UserId userId, BookCartElement bookCartElement) {
        String sqlQuery = "insert into book_list(user_id, book_id, quantity) values(?, ?, ?)";
        jdbcTemplate.update(sqlQuery, ps -> {
            ps.setString(1, userId.toString());
            ps.setString(2, bookCartElement.getBookId().toString());
            ps.setInt(3, bookCartElement.getQuantity().asInt());
        });
    }

    @Override
    public void update(UserId userId, LocalDate lastUpdateDate, TotalPrice totalPrice) {
        String sqlQuery = "update shopping_cart set last_update_date = ?, total_price = ? where user_id = ?";
        jdbcTemplate.update(sqlQuery, ps -> {
            ps.setDate(1, Date.valueOf(lastUpdateDate));
            ps.setBigDecimal(2, totalPrice.asBigDecimal());
            ps.setString(3, userId.toString());
        });
    }

    @Override
    public void updateBookList(UserId userId, BookCartElement bookCartElement) {
        String sqlQuery = "update book_list set quantity = ? where user_id = ? and book_id = ?";
        jdbcTemplate.update(sqlQuery, ps -> {
            ps.setInt(1, bookCartElement.getQuantity().asInt());
            ps.setString(2, userId.toString());
            ps.setString(3, bookCartElement.getBookId().toString());
        });
    }

    @Override
    public void delete(UserId userId, BookCartElement bookCartElement) {
        String sqlQuery = "delete from book_list where user_id = ? and book_id = ?";
        jdbcTemplate.update(sqlQuery, ps -> {
            ps.setString(1, userId.toString());
            ps.setString(2, bookCartElement.getBookId().toString());
        });
    }
}