package com.example.bookstore.repository.mapper;

import com.example.bookstore.model.Author;
import com.example.bookstore.model.Book;
import com.example.bookstore.model.Category;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper implements RowMapper<Book> {
    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Book(
                rs.getInt(1),
                rs.getString(2),
                new Author(
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getString(5)
                ),
                new Category(
                        rs.getInt(6),
                        rs.getString(7)
                ),
                rs.getInt(8),
                rs.getString(9)
        );
    }
}
