package com.mc.demo.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "用户信息")
@Entity
public class User {
    @ApiModelProperty(value = "用户id")
    @Id
    @GeneratedValue
    private long id;

    @ApiModelProperty(value = "用户账号")
    @Column(nullable = false)
    @NotNull
    private String username;

    @ApiModelProperty(value = "用户年龄")
    @Column(nullable = false)
    private int age;

    @ApiModelProperty(value = "用户密码")
    @Column
    private String password;

    @ApiModelProperty(value = "用户昵称")
    @Column
    private String nickName;

    public User() {
    }

    public User(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public User(String username, int age, String password) {
        this.username = username;
        this.age = age;
        this.password = password;
    }

    public User(String username, int age, String password, String nickName) {
        this.username = username;
        this.age = age;
        this.password = password;
        this.nickName = nickName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
