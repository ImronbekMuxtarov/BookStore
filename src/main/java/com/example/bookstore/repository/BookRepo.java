package com.example.bookstore.repository;

import com.example.bookstore.model.Book;
import com.example.bookstore.repository.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepo {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Book> getBooks(){
        return jdbcTemplate.query(
                "select b.id, b.title, a.id, a.name, a.address, c.id, c.name, b.year, b.language " +
                        "from books b " +
                        "join authors a on b.author_id = a.id " +
                        "join categories c on b.category_id = c.id ",
                new BookMapper()
        );
    }

    public Book getBook(int id){
        return jdbcTemplate.queryForObject(
                "select b.id, b.title, a.id, a.name, a.address, c.id, c.name, b.year, b.language " +
                        "from books b " +
                        "join authors a on b.author_id = a.id " +
                        "join categories c on b.category_id = c.id " +
                        "where b.id = ?",
                new Object[]{id},
                new BookMapper()
        );
    }

    public void addBook(Book book){
        jdbcTemplate.update(
                "insert into books(title, author_id, category_id, year, language) values (?, ?, ?, ?, ?)",
                book.getTitle(),
                book.getAuthor().getId(),
                book.getCategory().getId(),
                book.getYear(),
                book.getLanguage()
        );
    }

    public void updateBook(int id, Book book){
        jdbcTemplate.update(
                "update books set title = ?, author_id = ?, category_id = ?, year = ?, language = ? where id = ?",
                book.getTitle(),
                book.getAuthor().getId(),
                book.getCategory().getId(),
                book.getYear(),
                book.getLanguage(),
                id
        );
    }

    public void deleteBook(int id){
        jdbcTemplate.update(
                "delete from books where id = ?",
                id
        );
    }
}
