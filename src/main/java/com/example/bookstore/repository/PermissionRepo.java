package com.example.bookstore.repository;

import com.example.bookstore.model.Permission;
import com.example.bookstore.repository.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PermissionRepo {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Permission> getPermissions(){
        return jdbcTemplate.query(
                "select * from permissions",
                new PermissionMapper()
        );
    }

    public Permission getPermission(int id){
        return jdbcTemplate.queryForObject(
                "select * from permissions where id = ?",
                new Object[]{id},
                new PermissionMapper()
        );
    }

    public void addPermission(Permission permission){
        jdbcTemplate.update(
                "insert into permissions(name) values (?)",
                permission.getName()
        );
    }

    public void updatePermission(int id, Permission permission){
        jdbcTemplate.update(
                "update permissions set name = ? where id = ?",
                permission.getName(),
                id
        );
    }

    public void deletePermission(int id){
        jdbcTemplate.update(
                "delete from permissions where id = ?",
                id
        );
    }
}
