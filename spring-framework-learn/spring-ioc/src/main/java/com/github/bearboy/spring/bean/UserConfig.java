package com.github.bearboy.spring.bean;

import com.github.bearboy.spring.ioc.overview.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.io.ResourceLoader;

@Configuration
public class UserConfig {

    @Autowired
    private ApplicationContext applicationContext;

    @Bean(initMethod = "init", destroyMethod = "destroyMethod")
    public User user(ConfigurableEnvironment environment) {
        System.out.println(environment == applicationContext.getEnvironment());
        System.out.println(applicationContext.getBean(ConfigurableEnvironment.class) == environment);
        return new User();
    }
}
