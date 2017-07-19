package com.mc.demo.web;

import com.mc.demo.bean.UserBean;

import org.apache.catalina.User;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/users")
public class UserController {
    static Map<Long,UserBean> users= Collections.synchronizedMap(new HashMap<>());

    @ApiOperation(value = "获取用户列表" ,notes = "")
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<UserBean> getUserList(){
        List<UserBean> list=new ArrayList<>(users.values());
        return list;
    }

    @ApiOperation(value = "创建用户")
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public String postUser(@ModelAttribute UserBean user){
        if (user.getName().isEmpty()){
            return "error,用户名为空";
        }
        users.put(user.getId(),user);
        return "success";
    }

    @ApiOperation(value = "根据用户id获取用户")
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public UserBean getUser(@PathVariable long id){
        return users.get(id);
    }

    @ApiOperation(value = "更改用户")
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public String putUser(@PathVariable long id,@ModelAttribute UserBean user){
        UserBean u=users.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        users.put(id,u);
        return "success";
    }

    @ApiOperation(value = "删除用户")
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable long id){
        users.remove(id);
        return "success";
    }



}
