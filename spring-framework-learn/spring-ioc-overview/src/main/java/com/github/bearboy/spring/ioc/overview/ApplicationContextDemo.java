package com.github.bearboy.spring.ioc.overview;

import com.github.bearboy.spring.ioc.overview.pojo.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Spring ioc容器启动
 */
public class ApplicationContextDemo {
    public static void main(String[] args) {
        String location = "classpath:/META-INF/ioc-view.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
        context.setConfigLocation(location);
        //刷新容器
        context.refresh();
        User user = (User) context.getBean("user");
        System.out.println(user);
        //关闭容器
        context.close();
    }
}
