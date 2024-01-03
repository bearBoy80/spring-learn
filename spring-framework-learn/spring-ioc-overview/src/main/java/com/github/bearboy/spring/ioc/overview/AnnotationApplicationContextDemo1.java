package com.github.bearboy.spring.ioc.overview;

import com.github.bearboy.spring.ioc.overview.config.AppConfig;
import com.github.bearboy.spring.ioc.overview.pojo.SupperUser;
import com.github.bearboy.spring.ioc.overview.pojo.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration(proxyBeanMethods = false)
public class AnnotationApplicationContextDemo1 {
    public static void main(String[] args) {
        //根据配置自动扫描特定路径的包，然后再refresh
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        System.out.println(context.getBean("user"));
        System.out.println(context.getBean(SupperUser.class));
    }
    @Bean
    public User user(){
        return new User();
    }
}
