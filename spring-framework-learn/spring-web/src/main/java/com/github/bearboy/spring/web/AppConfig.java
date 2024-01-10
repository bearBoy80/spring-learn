package com.github.bearboy.spring.web;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "com.github.bearboy.spring.web")
@EnableWebMvc
public class AppConfig {
    public AppConfig() {
        System.out.println("AppConfig 初始化中");
    }
}
