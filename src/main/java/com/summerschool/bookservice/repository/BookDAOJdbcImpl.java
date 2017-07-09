package com.summerschool.bookservice.repository;

import com.summerschool.bookservice.beans.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

//Uncomment annotation to use jdbc instead of JPA
//@Repository
public class BookDAOJdbcImpl implements BookDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Book getBook(Long bookId) {
        return null;
    }

    @Override
    public Book save(Book book) {
        return null;
    }

    @Override
    public Book update(Book book) {
        return null;
    }

    @Override
    public void delete(Book book) {

    }

    @Override
    public List<Book> findBooks(String name) {
        List<Book> bookList = jdbcTemplate.query("SELECT book_id, book_name, description FROM book WHERE book_name LIKE ?",
                new Object[]{"%" + name + "%"},
                (rs, rowNum) -> {
                    Book book = new Book();
                    book.setBookId(rs.getLong("book_id"));
                    book.setBookName(rs.getString("book_name"));
                    book.setDescription(rs.getString("description"));
                    return book;
                });
        return bookList;
    }
}
