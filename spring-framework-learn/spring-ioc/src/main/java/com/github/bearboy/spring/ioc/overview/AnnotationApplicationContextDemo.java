package com.github.bearboy.spring.ioc.overview;

import com.github.bearboy.spring.ioc.overview.pojo.SupperUser;
import com.github.bearboy.spring.ioc.overview.pojo.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * 通过注解AnnotationConfigApplicationContext来获取 user、SupperUser 实例
 * 注意点：
 * 1、手动自动包扫描路径
 */
public class AnnotationApplicationContextDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AnnotationApplicationContextDemo.class);
        context.scan(AnnotationApplicationContextDemo.class.getPackage().getName());
        context.refresh();
        System.out.println(context.getBean("user"));
        System.out.println(context.getBean(SupperUser.class));
    }

    @Bean(name = "user")
    public User user() {
        return new User();
    }
}
