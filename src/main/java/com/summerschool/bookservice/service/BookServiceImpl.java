package com.summerschool.bookservice.service;

import com.summerschool.bookservice.beans.Book;
import com.summerschool.bookservice.beans.User;
import com.summerschool.bookservice.repository.BookDAO;
import com.summerschool.bookservice.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
public class BookServiceImpl implements BookService {
    
    @Autowired
    private BookDAO bookDAO;
    
    @Autowired
    private UserDAO userDAO;
    
    @Transactional
    @Override
    public Book getBook(Long bookId) {
        return bookDAO.getBook(bookId);
    }

    @Transactional
    @Override
    public Book save(Book book, Long userId) {
        User user = userDAO.getUser(userId);
        if (user == null) {
            throw new ServiceException("User with specified id is not found");
        }
        book.setOwner(user);
        bookDAO.save(book);
        return book;
    }

    @Transactional
    @Override
    public Book update(Book book) {
        return bookDAO.update(book);
    }

    @Transactional
    @Override
    public void delete(Book book) {
        bookDAO.delete(book);
    }

    @Override
    public Set<Book> listOwnerBooks(Long userId) {
        User user = userDAO.getUser(userId);
        if (user == null) {
            throw new ServiceException("User with specified id is not found");
        }
        return user.getBooks();
    }

    @Override
    public List<Book> findBooks(String name) {
        return bookDAO.findBooks(name);
    }
}
