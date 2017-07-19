package com.mc.demo.db;

public interface UserService {
    void create(String name,int age);
    void deleteByName(String name);
    Integer getAllUser();
    void deleteAll();
}
