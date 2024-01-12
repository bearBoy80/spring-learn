package com.github.bearboy.spring.type.converter;

import java.util.Date;

public class Person {
    private Date birthDay;
    private String name;

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
