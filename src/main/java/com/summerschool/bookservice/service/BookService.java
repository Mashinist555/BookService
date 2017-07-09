package com.summerschool.bookservice.service;

import com.summerschool.bookservice.beans.Book;

import java.util.List;
import java.util.Set;

public interface BookService {
    
    Book getBook(Long bookId);
    
    Book save(Book book, Long userId);
    
    Book update(Book book);
    
    void delete(Book book);

    Set<Book> listOwnerBooks(Long userId);

    List<Book> findBooks(String name);
}
