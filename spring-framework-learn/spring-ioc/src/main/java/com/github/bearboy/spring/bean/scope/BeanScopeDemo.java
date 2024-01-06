package com.github.bearboy.spring.bean.scope;

import com.github.bearboy.spring.ioc.overview.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import java.util.List;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

/**
 * 单例在每次依赖查找或者注入都是同一个实例
 * 原型在每次依赖查找或者注入都是不同实例
 * 原型bean只有只有初始化相关回调，无销毁相关回调
 * 针对集合查找，原型会重新实例化一个新的Bean
 */
public class BeanScopeDemo {
    static int index = 19;
    @Autowired
    @Qualifier(value = "user")
    private User user;

    @Autowired
    @Qualifier(value = "prototypeUser")
    private User prototypeUser;

    @Autowired
    @Qualifier(value = "prototypeUser")
    private User prototypeUser1;

    @Autowired
    @Qualifier(value = "prototypeUser")
    private User prototypeUser2;

    @Autowired
    private List<User> list;
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(BeanScopeDemo.class);
        context.refresh();
        BeanScopeDemo demo  = context.getBean(BeanScopeDemo.class);
        System.out.println(demo.list);
        context.close();
    }

    @Bean
    public User user(){
        User user = new User();
        user.setName("singleton user");
        user.setAge(18);
        return user;
    }
    @Bean
    @Scope(value = SCOPE_PROTOTYPE)
    public User prototypeUser(){
        User user = new User();
        user.setName("prototype user");
        user.setAge(index++);
        return user;
    }
}
