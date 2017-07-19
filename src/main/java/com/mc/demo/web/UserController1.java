package com.mc.demo.web;

import com.mc.demo.bean.User;
import com.mc.demo.db.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "用户相关操作")
@RestController
@RequestMapping(value = "${project.name}/users")
public class UserController1 {
    @Autowired
    private UserRepository userRepository;

    @ApiOperation(value = "用户注册")
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ApiImplicitParams(@ApiImplicitParam(name = "id",paramType = "query",dataType = "String",value = "用户id"))
    public ResultInfo<String> register(@ModelAttribute User user) throws Exception{
        if(user.getUsername().isEmpty()){
            throw new MyException("用户名为空!");
        }else if(user.getAge()<=0){
            throw new MyException("年龄非法!");
        }else if(user.getPassword().isEmpty())
        {
            throw new MyException("错误的密码");
        }
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new MyException("该用户名已注册");
        }
        userRepository.save(user);
        return new SuccessInfo<String>("注册成功");
    }

    @ApiOperation(value = "用户登录")
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResultInfo<User> login( @RequestParam String username, @RequestParam String password) throws MyException {
        if(username.isEmpty()||password.isEmpty())
        {
            throw new MyException("用户账号或密码为空");
        }
        User user=userRepository.findUser(username);
        if(user==null)
        {
            throw new MyException("该账号尚未注册,请先注册.");
        }
        if (password.equals(user.getPassword())) {
            return new SuccessInfo<User>("登录成功",user);
        }else{
            throw new MyException("用户账号或密码错误");
        }
    }

    @ApiOperation(value = "修改密码")
    @RequestMapping(value = "changeps",method = RequestMethod.POST)
    public ResultInfo<String> changePs(@RequestParam String username,@RequestParam String oldPassword,@RequestParam String newPassword) throws Exception{
        if(username.isEmpty()||oldPassword.isEmpty()||newPassword.isEmpty()){
            throw new MyException("用户账号或密码为空");
        }
        if(oldPassword.equals(newPassword)){
            throw new MyException("新旧密码不能相同");
        }
        User byUsername = userRepository.findByUsername(username);
        if(byUsername==null)
        {
            throw new MyException("该账号尚未注册,请先注册.");
        }
        if(!byUsername.getPassword().equals(oldPassword))
        {
            throw new MyException("账号或密码错误");
        }
        byUsername.setPassword(newPassword);
        userRepository.save(byUsername);
        return new SuccessInfo<String>("密码修改成功");
    }

    @ApiOperation(value = "查看所有用户信息")
    @RequestMapping(value = "showall",method = RequestMethod.POST)
    public ResultInfo<List<User>> findAllUser(){
        return new SuccessInfo<List<User>>("",userRepository.findAll());
    }
}
