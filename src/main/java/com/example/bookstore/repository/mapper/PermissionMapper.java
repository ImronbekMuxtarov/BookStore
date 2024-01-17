package com.example.bookstore.repository.mapper;

import com.example.bookstore.model.Permission;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PermissionMapper implements RowMapper<Permission> {
    @Override
    public Permission mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Permission(
                rs.getInt(1),
                rs.getString(2)
        );
    }
}
