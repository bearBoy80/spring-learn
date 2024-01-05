package com.github.bearboy.spring.ioc.overview.pojo;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class User implements InitializingBean , DisposableBean {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    public static User createUser(){
        User user =new User();
        user.setAge(18);
        user.setName("grille");
        return user;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("user init by afterPropertiesSet" );
    }
    @PostConstruct
    public void PostConstruct(){
        System.out.println("user init by PostConstruct" );

    }
    void init(){
        System.out.println("user init by @Bean init method" );
    }
    @PreDestroy
    public void PreDestroy(){
        System.out.println("user destroy by PreDestroy" );

    }
    void destroyMethod(){
        System.out.println("user destroy by @Bean destroyMethod" );
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("user destroy by DisposableBean" );

    }
}
