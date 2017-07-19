package com.mc.demo.db;

import com.mc.demo.bean.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Long>{
    User findByUsername(String name);

    User findByUsernameAndAge(String name,String age);

    @Query("select u from User u where u.username=:name")
    User findUser(@Param("name") String name);

}
