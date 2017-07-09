package com.summerschool.bookservice.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.summerschool.bookservice.beans.User;
import com.summerschool.bookservice.beans.View;
import com.summerschool.bookservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{userId}")
    @JsonView(View.Summary.class)
    public User getUser(@PathVariable Long userId) {
        return userService.getUser(userId);
    }

    @RequestMapping(method = RequestMethod.POST)
    @JsonView(View.Summary.class)
    public User addUser(@RequestBody User user) {
        return userService.save(user);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @JsonView(View.Summary.class)
    public User updateUser(@RequestBody User user) {
        return userService.update(user);
    }

    @RequestMapping(value = "/{userId}/with-books")
    @JsonView(View.Full.class)
    public User getUserWithBooks(@PathVariable Long userId) {
        return userService.getUserWithBooks(userId);
    }

    @RequestMapping(value = "/all")
    @JsonView(View.Summary.class)
    public List<User> listUsers() {
        return userService.listUsers();
    }

    @RequestMapping(value = "/find")
    @JsonView(View.Summary.class)
    public List<User> findUsers(@RequestParam String name, @RequestParam String lastName) {
        return userService.findUsers(name, lastName);
    }

}
