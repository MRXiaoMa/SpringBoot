package com.mc.demo.db;

import com.mc.demo.bean.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.logging.Logger;

import sun.rmi.runtime.Log;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void test() throws Exception{
        userRepository.save(new User("张三",10));
        userRepository.save(new User("李四",11));
        userRepository.save(new User("王五",12));
        userRepository.save(new User("赵六",13));
        userRepository.save(new User("田七",10));
        userRepository.save(new User("陈八",10));
        userRepository.save(new User("许九",12));
        userRepository.save(new User("尧十三",13));
        userRepository.save(new User("流矢死",10));
        userRepository.save(new User("哈哈",10));

        System.out.print("size>>>>>>>>>>>>>>>>>>>>>>>"+userRepository.findAll().size()+"\n");
        assertEquals(10,userRepository.findAll().size());

        assertEquals(10,userRepository.findByUsername("张三").getAge());

        assertEquals(13,userRepository.findUser("赵六").getAge());

        userRepository.delete(userRepository.findByUsername("张三"));

        assertEquals(9,userRepository.findAll().size());

        userRepository.deleteAll();

    }

}