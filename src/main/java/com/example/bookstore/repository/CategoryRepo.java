package com.example.bookstore.repository;

import com.example.bookstore.model.Category;
import com.example.bookstore.repository.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryRepo {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Category> getCategories(){
        return jdbcTemplate.query(
                "select * from categories",
                new CategoryMapper()
        );
    }

    public Category getCategory(int id){
        return jdbcTemplate.queryForObject(
                "select * from categories where id = ?",
                new Object[]{id},
                new CategoryMapper()
        );
    }

    public void addCategory(Category category){
        jdbcTemplate.update(
                "insert into categories(name) values (?)",
                category.getName()
        );
    }

    public void updateCategory(int id, Category category){
        jdbcTemplate.update(
                "update categories set name = ? where id = ?",
                category.getName(),
                id
        );
    }

    public void deleteCategory(int id){
        jdbcTemplate.update(
                "delete from categories where id = ?",
                id
        );
    }
}
