package com.github.bearboy.spring.enviroment;

import com.github.bearboy.spring.ioc.overview.pojo.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 属性占位符demo
 */
public class PropertyPlaceholderConfigurerDemo {
    public static void main(String[] args) {
        // 创建并且启动 Spring 应用上下文
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/placeholders-resolver.xml");
        User user = context.getBean("user", User.class);
        System.out.println(user);

        // 关闭 Spring 应用上下文
        context.close();
    }
}
