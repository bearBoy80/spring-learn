package com.github.bearboy.spring.annotate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class HelloWorldConfiguration {
    @Bean
    public String helloWorld() {
        System.out.println("configurable hello world");
        return "hell world";
    }
}
