package com.summerschool.bookservice.repository;

import com.summerschool.bookservice.beans.Book;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class BookDAOImpl implements BookDAO {
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Book getBook(Long bookId) {
        return entityManager.find(Book.class, bookId);
    }

    @Override
    public Book save(Book book) {
        entityManager.persist(book);
        return book;
    }

    @Override
    public Book update(Book book) {
        return entityManager.merge(book);
    }

    @Override
    public void delete(Book book) {
        entityManager.remove(book);
    }

    @Override
    public List<Book> findBooks(String name) {
        TypedQuery<Book> query = entityManager.createNamedQuery("Book.find", Book.class)
                .setParameter("name", "%" + name + "%");
        return query.getResultList();
    }
}
