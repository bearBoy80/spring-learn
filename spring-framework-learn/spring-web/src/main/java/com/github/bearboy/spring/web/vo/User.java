package com.github.bearboy.spring.web.vo;

import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class User {
    @NotBlank
    private String name;
    @Min(value = 18)
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
