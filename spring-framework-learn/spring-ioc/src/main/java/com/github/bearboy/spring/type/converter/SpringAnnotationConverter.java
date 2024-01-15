package com.github.bearboy.spring.type.converter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Date;

public class SpringAnnotationConverter {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfig.class);
        context.register(SpringAnnotationConverter.class);
        context.refresh();
        System.out.printf("finish");
    }
    @Bean
    Person getPerson(@Value("${person.birthday}") Date date){
        Person person = new Person();
        System.out.println(date);
        return person;
    }
}