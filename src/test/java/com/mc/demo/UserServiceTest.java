package com.mc.demo;

import com.mc.demo.db.UserService;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Before
    public void setUp(){
        userService.deleteAll();
    }

    @Test
    public void  test() throws Exception{
        userService.create("a",1);
        userService.create("b",2);
        userService.create("c",3);
        userService.create("d",2);
        userService.create("e",1);

        Assert.assertEquals(5,userService.getAllUser().intValue());

        userService.deleteByName("a");
        userService.deleteByName("b");

        Assert.assertEquals(3,userService.getAllUser().intValue());
    }
}
