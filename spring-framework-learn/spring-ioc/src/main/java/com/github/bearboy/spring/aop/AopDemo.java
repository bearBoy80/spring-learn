package com.github.bearboy.spring.aop;

import com.github.bearboy.spring.aop.service.MyService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author:bearBoy80
 * @date: 2024/1/25
 * @sina 1.0
 * @Description:
 */
public class AopDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/aop-view.xml");
        MyService myService = context.getBean("myService", MyService.class);
        myService.doSomething();
        context.close();
    }
}
