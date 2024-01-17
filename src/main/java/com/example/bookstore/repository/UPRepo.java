package com.example.bookstore.repository;

import com.example.bookstore.model.UP;
import com.example.bookstore.repository.mapper.UPMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UPRepo {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<UP> getUPs(){
        return jdbcTemplate.query(
                "select * from user_permission",
                new UPMapper()
        );
    }

    public List<UP> getUPsByUserId(int userId){
        return jdbcTemplate.query(
                "select * from user_permission where user_id = ?",
                new Object[]{userId},
                new UPMapper()
        );
    }

    public List<UP> getUPsByPermissionId(int permissionId){
        return jdbcTemplate.query(
                "select * from user_permission where permission_id = ?",
                new Object[]{permissionId},
                new UPMapper()
        );
    }

    public void addUP(UP up){
        jdbcTemplate.update(
                "insert into user_permission values (?, ?)",
                up.getUserId(),
                up.getPermissionId()
        );
    }

    public void updateUP(UP oldUp, UP newUp){
        jdbcTemplate.update(
                "update user_permission set user_id = ?, permission_id = ? where user_id = ? and permission_id = ?",
                newUp.getUserId(),
                newUp.getPermissionId(),
                oldUp.getUserId(),
                oldUp.getPermissionId()
        );
    }

    public void deleteUP(UP up){
        jdbcTemplate.update(
                "delete from user_permission where user_id = ? and permission_id = ?",
                up.getUserId(),
                up.getPermissionId()
        );
    }
}
