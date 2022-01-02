package com.david.bookstore.repository.book;

import com.david.bookstore.domain.book.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Repository
public class BookRepositoryImplementation implements BookRepository {

    private final JdbcTemplate jdbcTemplate;

    public BookRepositoryImplementation(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Book> rowMapper = (resultSet, rowNum) -> {
        BookId bookId = BookId.fromString(resultSet.getString("book_id"));
        BookCover bookCover = new BookCover(resultSet.getString("book_cover"));
        BookName bookName = new BookName(resultSet.getString("book_name"));
        BookAuthor bookAuthor = new BookAuthor(resultSet.getString("book_author"));
        LocalDate bookPublicationDate = resultSet.getDate("book_publication_date").toLocalDate();
        BookSynopsis bookSynopsis = new BookSynopsis(resultSet.getString("book_synopsis"));
        BookCategory bookCategory = new BookCategory(resultSet.getString("book_category"));
        BookPrice bookPrice = new BookPrice((resultSet.getBigDecimal("book_price")));

        return new Book(
                bookId,
                bookCover,
                bookName,
                bookAuthor,
                bookPublicationDate,
                bookSynopsis,
                bookCategory,
                bookPrice
        );
    };

    @Override
    public List<Book> getAll() {
        String sqlQuery = "select * from books";
        return jdbcTemplate.query(sqlQuery, rowMapper);
    }

    @Override
    public Book getById(BookId bookId) {
        String sqlQuery = "select * from books where book_id = ?";
        return jdbcTemplate.queryForObject(sqlQuery, rowMapper, bookId.toString());
    }

    @Override
    public List<Book> getByAuthor(BookAuthor bookAuthor) {
        String sqlQuery = "select * from books where book_author = ?";
        return jdbcTemplate.query(sqlQuery, rowMapper, bookAuthor.toString());
    }

    @Override
    public List<Book> getByCategory(BookCategory bookCategory) {
        String sqlQuery = "select * from books where book_category = ?";
        return jdbcTemplate.query(sqlQuery, rowMapper, bookCategory.toString());
    }

    @Override
    public void create(Book book) {
        String sqlQuery = "insert into books(book_id, book_cover, book_name, book_author, book_publication_date, book_synopsis, book_category, book_price) values(?, ?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sqlQuery, ps -> {
            ps.setString(1, book.getBookId().toString());
            ps.setString(2, book.getBookCover().toString());
            ps.setString(3, book.getBookName().toString());
            ps.setString(4, book.getBookAuthor().toString());
            ps.setDate(5, Date.valueOf(book.getBookPublicationDate()));
            ps.setString(6, book.getBookSynopsis().toString());
            ps.setString(7, book.getBookCategory().toString());
            ps.setBigDecimal(8, book.getBookPrice().asBigDecimal());
        });
    }

    @Override
    public void update(BookId bookId, Book book) {
        String sqlQuery = "update books set book_cover = ?, book_name = ?, book_author = ?, book_publication_date = ?, book_synopsis = ?, book_category = ?, book_price = ? where book_id = ?";
        jdbcTemplate.update(sqlQuery, ps -> {
            ps.setString(1, book.getBookCover().toString());
            ps.setString(2, book.getBookName().toString());
            ps.setString(3, book.getBookAuthor().toString());
            ps.setDate(4, Date.valueOf(book.getBookPublicationDate()));
            ps.setString(5, book.getBookSynopsis().toString());
            ps.setString(6, book.getBookCategory().toString());
            ps.setBigDecimal(7, book.getBookPrice().asBigDecimal());
            ps.setString(8, book.getBookId().toString());
        });
    }

    @Override
    public void delete(BookId bookId) {
        String sqlQuery = "delete from books where book_id = ?";
        jdbcTemplate.update(sqlQuery, bookId.toString());
    }
}
