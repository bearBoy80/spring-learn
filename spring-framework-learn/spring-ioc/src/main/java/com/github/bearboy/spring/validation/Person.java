package com.github.bearboy.spring.validation;

import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NegativeOrZero;
import javax.validation.constraints.NotNull;

public class Person {

    @Min(value = 1)
    private int age;
    @NotNull
    private String name;

    @Valid
    private Profie profie;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Profie getProfie() {
        return profie;
    }

    public void setProfie(Profie profie) {
        this.profie = profie;
    }
}
