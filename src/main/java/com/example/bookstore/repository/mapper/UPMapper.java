package com.example.bookstore.repository.mapper;

import com.example.bookstore.model.UP;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UPMapper implements RowMapper<UP> {
    @Override
    public UP mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new UP(
                rs.getInt(1),
                rs.getInt(2)
        );
    }
}
