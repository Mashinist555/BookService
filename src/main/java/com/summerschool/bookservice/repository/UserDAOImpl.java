package com.summerschool.bookservice.repository;

import com.summerschool.bookservice.beans.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User getUser(Long userId) {
        return entityManager.find(User.class, userId);
    }

    @Override
    public User save(User user) {
        entityManager.persist(user);
        return user;
    }

    @Override
    public User update(User user) {
        return entityManager.merge(user);
    }

    @Override
    public void delete(User user) {
        entityManager.remove(user);
    }

    @Override
    public List<User> listUsers() {
        TypedQuery<User> query = entityManager.createNamedQuery("User.listAll", User.class);
        return query.getResultList();
    }

    @Override
    public List<User> findUsers(String name, String lastName) {
        TypedQuery<User> query = entityManager.createNamedQuery("User.find", User.class)
                .setParameter("name", "%" + name + "%")
                .setParameter("lastName", "%" + lastName + "%");
        return query.getResultList();
    }
}
