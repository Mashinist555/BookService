package com.summerschool.bookservice.repository;

import com.summerschool.bookservice.beans.Book;

import java.util.List;

public interface BookDAO {

    Book getBook(Long bookId);

    Book save(Book book);

    Book update(Book book);

    void delete(Book book);

    List<Book> findBooks(String name);
}
