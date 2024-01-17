package com.example.bookstore.controller;

import com.example.bookstore.model.Book;
import com.example.bookstore.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookRepo bookRepo;

    @GetMapping
    public List<Book> getBooks(){
        return bookRepo.getBooks();
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable int id){
        return bookRepo.getBook(id);
    }

    @PostMapping
    public String addBook(@RequestBody Book book){
        bookRepo.addBook(book);
        return "Added";
    }

    @PutMapping("/{id}")
    public String updateBook(@PathVariable int id, @RequestBody Book book){
        bookRepo.updateBook(id, book);
        return "Updated";
    }

    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id){
        bookRepo.deleteBook(id);
        return "Deleted";
    }
}
