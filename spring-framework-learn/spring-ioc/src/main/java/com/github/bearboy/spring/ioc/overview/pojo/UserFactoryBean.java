package com.github.bearboy.spring.ioc.overview.pojo;

import org.springframework.beans.factory.FactoryBean;

public class UserFactoryBean implements FactoryBean<User> {
    @Override
    public User getObject() throws Exception {
        User user = new User();
        user.setAge(18);
        user.setName("UserFactoryBean");
        return user;
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
