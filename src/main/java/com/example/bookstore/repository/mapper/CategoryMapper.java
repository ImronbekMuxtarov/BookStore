package com.example.bookstore.repository.mapper;

import com.example.bookstore.model.Category;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryMapper implements RowMapper<Category> {
    @Override
    public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Category(
                rs.getInt(1),
                rs.getString(2)
        );
    }
}
