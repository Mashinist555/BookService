package com.summerschool.bookservice.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.summerschool.bookservice.beans.Book;
import com.summerschool.bookservice.beans.View;
import com.summerschool.bookservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/book")
public class BookController {
    
    @Autowired
    private BookService bookService;

    @JsonView(View.Summary.class)
    @RequestMapping(value = "/{bookId}")
    public Book getBook(@PathVariable Long bookId) {
        return bookService.getBook(bookId);
    }

    @JsonView(View.Summary.class)
    @RequestMapping(method = RequestMethod.POST)
    public Book addBook(@RequestParam Long userId, @RequestBody Book book) {
        return bookService.save(book, userId);
    }

    @JsonView(View.Summary.class)
    @RequestMapping(method = RequestMethod.PUT) 
    public Book updateBook(@RequestBody Book book) {
        return bookService.update(book);
    }

    @JsonView(View.Summary.class)
    @RequestMapping(value = "/list/owner/{userId}")
    public Set<Book> listOwnerBooks(@PathVariable Long userId) {
        return bookService.listOwnerBooks(userId);
    }
    
    @JsonView(View.Summary.class)
    @RequestMapping(value = "/find")
    public List<Book> findBooks(@RequestParam String name) {
        return bookService.findBooks(name);
    }
}
