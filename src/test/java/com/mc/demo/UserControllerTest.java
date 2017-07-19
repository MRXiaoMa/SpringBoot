package com.mc.demo;

import com.mc.demo.web.UserController;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {
    private MockMvc mvc;
    @Before
    public void setUp() throws Exception{
        mvc= MockMvcBuilders.standaloneSetup(new UserController()).build();
    }

    @Test
    public void testUserController() throws Exception{
        RequestBuilder request=null;

        request=get("/users/");
        mvc.perform(request).andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));

        request=post("/users/")
                .param("id","1")
                .param("name","张三")
                .param("age","20");
        mvc.perform(request).andExpect(status().isOk())
                .andExpect(content().string(equalTo("success")));

        request=get("/users/1");
        mvc.perform(request).andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\"id\":1,\"name\":\"张三\",\"age\":20}")));

        request=delete("/users/1");
        mvc.perform(request).andExpect(content().string(equalTo("success")));

        request=get("/users/");
        mvc.perform(request).andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));

    }



}
