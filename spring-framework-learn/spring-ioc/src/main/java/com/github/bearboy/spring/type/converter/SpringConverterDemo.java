package com.github.bearboy.spring.type.converter;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringConverterDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
        String config = "classpath:/META-INF/spring-converter.xml";
        context.setConfigLocation(config);
        context.refresh();
        Person person = context.getBean(Person.class);
        System.out.println(person.getProperties().get("user.name"));
        System.out.println(person.getProperties().get("user.age"));
        context.close();
    }
}
