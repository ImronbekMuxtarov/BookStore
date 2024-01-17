package com.example.bookstore.controller;

import com.example.bookstore.model.Category;
import com.example.bookstore.repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryRepo categoryRepo;

    @GetMapping
    public List<Category> getCategories(){
        return categoryRepo.getCategories();
    }

    @GetMapping("/{id}")
    public Category getCategory(@PathVariable int id){
        return categoryRepo.getCategory(id);
    }

    @PostMapping
    public String addCategory(@RequestBody Category category){
        categoryRepo.addCategory(category);
        return "Added";
    }

    @PutMapping("/{id}")
    public String updateCategory(@PathVariable int id, @RequestBody Category category){
        categoryRepo.updateCategory(id, category);
        return "Updated";
    }

    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable int id){
        categoryRepo.deleteCategory(id);
        return "Deleted";
    }
}
