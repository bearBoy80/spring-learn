package com.github.bearboy.spring.i8n;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

public class SpringI8NDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-i8n.xml",
                SpringI8NDemo.class);
        String message = context.getMessage("message", null,
                "Default", Locale.getDefault());
        System.out.println(message);
        context.refresh();
    }
}
