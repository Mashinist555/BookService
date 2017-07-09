package com.summerschool.bookservice.service;

import com.summerschool.bookservice.beans.User;
import com.summerschool.bookservice.repository.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Transactional
    @Override
    public User getUser(Long userId) {
        return userDAO.getUser(userId);
    }

    @Transactional
    @Override
    public User save(User user) {
        return userDAO.save(user);
    }

    @Transactional
    @Override
    public User update(User user) {
        return userDAO.update(user);
    }

    @Transactional
    @Override
    public void delete(User user) {
        userDAO.delete(user);
    }

    @Transactional
    @Override
    public User getUserWithBooks(Long userId) {
        User user = userDAO.getUser(userId);
        user.getBooks().size();
        return user;
    }

    @Transactional
    @Override
    public List<User> listUsers() {
        return userDAO.listUsers();
    }

    @Transactional
    @Override
    public List<User> findUsers(String name, String lastName) {
        return userDAO.findUsers(name, lastName);
    }


}
