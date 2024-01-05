package com.github.bearboy.spring.ioc.overview.pojo;

public class DefaultUseFactory implements UserFactory {
    @Override
    public User createUser(String name, int age) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        return user;
    }
}
