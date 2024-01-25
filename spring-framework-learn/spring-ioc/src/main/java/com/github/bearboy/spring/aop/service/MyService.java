package com.github.bearboy.spring.aop.service;

import org.springframework.stereotype.Service;

@Service
public class MyService {
    public void doSomething() {
        System.out.println("Doing something...");
    }
}