package com.lzjrabbitmq.bean;

import lombok.Data;

@Data
public class User {

    private String name;
    private Integer age;

    //记得加无参构造器，否则序列化会有问题
    public User() {
    }

    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
