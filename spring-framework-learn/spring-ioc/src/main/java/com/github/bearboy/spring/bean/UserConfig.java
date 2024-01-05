package com.github.bearboy.spring.bean;

import com.github.bearboy.spring.ioc.overview.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
    @Bean(initMethod = "init",destroyMethod = "destroyMethod")
    public User user(){
       return new User();
    }
}
