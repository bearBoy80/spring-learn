package com.github.bearboy.spring.ioc.overview;

import com.github.bearboy.spring.ioc.overview.pojo.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ResourceLoader;

/**
 * 依赖查找与依赖注入的区别
 * 依赖来源不同，
 * 比如：registerResolvableDependency方法注册的bean，无法被依赖查找
 * 外部化配置的数据也无法被依赖查找
 */
public class LookupAndDependencyInjectDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(LookupAndDependencyInjectDemo.class);
        //刷新容器
        context.refresh();
        User user = (User) context.getBean("user");
        System.out.println(user);
        //报错NoSuchBeanDefinitionException
        context.getBean(ResourceLoader.class);
        //关闭容器
        context.close();
    }
    @Bean
    public User user(ResourceLoader resourceLoader,  @Value("${user.dir}")String userDir){
        //不会报错
        System.out.println("resourceLoader 注入成功" + resourceLoader);
        System.out.println(userDir);
        return  new User();
    }
}
