package com.mc.demo.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BlogProperties {
    @Value("${com.mc.name}")
    private String name;
    @Value("${com.mc.age}")
    private String age;

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }
}
