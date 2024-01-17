package com.example.bookstore.repository;

import com.example.bookstore.model.Author;
import com.example.bookstore.repository.mapper.AuthorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorRepo {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Author> getAuthors(){
        return jdbcTemplate.query(
                "select * from authors",
                new AuthorMapper()
        );
    }

    public Author getAuthor(int id){
        return jdbcTemplate.queryForObject(
                "select * from authors where id = ?",
                new Object[]{id},
                new AuthorMapper()
        );
    }

    public void addAuthor(Author author){
        jdbcTemplate.update(
                "insert into authors(name, address) values (?, ?)",
                author.getName(),
                author.getAddress()
        );
    }

    public void updateAuthor(int id, Author author){
        jdbcTemplate.update(
                "update authors set name = ?, address = ? where id = ?",
                author.getName(),
                author.getAddress(),
                id
        );
    }

    public void deleteAuthor(int id){
        jdbcTemplate.update(
                "delete from authors where id = ?",
                id
        );
    }
}
