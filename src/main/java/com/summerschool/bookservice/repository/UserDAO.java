package com.summerschool.bookservice.repository;

import com.summerschool.bookservice.beans.User;

import java.util.List;

public interface UserDAO {

    User getUser(Long userId);

    User save(User user);

    User update(User user);

    void delete(User user);

    List<User> listUsers();

    List<User> findUsers(String name, String lastName);
}
