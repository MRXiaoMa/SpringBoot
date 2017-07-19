package com.mc.demo.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(String name, int age) {
        jdbcTemplate.update("INSERT  INTO USER(name,age) VALUES (?,?)",name,age);
    }

    @Override
    public void deleteByName(String name) {
        jdbcTemplate.update("DELETE FROM USER WHERE NAME =?",name);
    }

    @Override
    public Integer getAllUser() {
       return jdbcTemplate.queryForObject("select count(1) from user",Integer.class);
    }

    @Override
    public void deleteAll() {
        jdbcTemplate.update("DELETE FROM USER");
    }
}
