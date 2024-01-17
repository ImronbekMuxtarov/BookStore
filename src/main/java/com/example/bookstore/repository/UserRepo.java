package com.example.bookstore.repository;

import com.example.bookstore.model.User;
import com.example.bookstore.repository.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepo {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<User> getUsers(){
        return jdbcTemplate.query(
                "select * from users",
                new UserMapper()
        );
    }

    public User getUser(int id){
        return jdbcTemplate.queryForObject(
                "select * from users where id = ?",
                new Object[]{id},
                new UserMapper()
        );
    }

    public void addUser(User user){
        jdbcTemplate.update(
                "insert into users(username, password, role) values (?, ?)",
                user.getUsername(),
                user.getPassword(),
                user.getRole()
        );
    }

    public void updateUser(int id, User user){
        jdbcTemplate.update(
                "update users set username = ?, password = ? where id = ?",
                user.getUsername(),
                user.getPassword(),
                id
        );
    }

    public void deleteUser(int id){
        jdbcTemplate.update(
                "delete from users where id = ?",
                id
        );
    }
}
