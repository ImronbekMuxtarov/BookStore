package com.example.bookstore.controller;

import com.example.bookstore.model.Author;
import com.example.bookstore.repository.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorRepo authorRepo;

    @GetMapping
    public List<Author> getBooks(){
        return authorRepo.getAuthors();
    }

    @GetMapping("/{id}")
    public Author getAuthor(@PathVariable int id){
        return authorRepo.getAuthor(id);
    }

    @PostMapping
    public String addAuthor(@RequestBody Author author){
        authorRepo.addAuthor(author);
        return "Added";
    }

    @PutMapping("/{id}")
    public String updateAuthor(@PathVariable int id, @RequestBody Author author){
        authorRepo.updateAuthor(id, author);
        return "Updated";
    }

    @DeleteMapping("/{id}")
    public String deleteAuthor(@PathVariable int id){
        authorRepo.deleteAuthor(id);
        return "Deleted";
    }
}
