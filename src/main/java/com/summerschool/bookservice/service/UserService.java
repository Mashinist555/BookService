package com.summerschool.bookservice.service;

import com.summerschool.bookservice.beans.User;

import java.util.List;

/**
 * Created by sbabkin on 7/2/2017.
 */
public interface UserService {
    
    User getUser(Long userId);
    
    User save(User user);
    
    User update(User user);
    
    void delete(User user);

    User getUserWithBooks(Long userId);

    List<User> listUsers();

    List<User> findUsers(String name, String lastName);
}
