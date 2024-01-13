package com.github.bearboy.spring.type.converter;

import java.util.Date;
import java.util.Properties;

public class Person {
    private Date birthDay;
    private String name;

    private Properties properties;

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

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

    @Override
    public String toString() {
        return "Person{" +
                "birthDay=" + birthDay +
                ", name='" + name + '\'' +
                ", properties=" + properties +
                '}';
    }
}
