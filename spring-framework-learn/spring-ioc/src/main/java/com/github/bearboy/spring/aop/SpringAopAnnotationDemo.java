package com.github.bearboy.spring.aop;

import com.github.bearboy.spring.aop.aspect.MyAspect;
import com.github.bearboy.spring.aop.service.MyService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author:bearBoy80
 * @date: 2024/1/25
 * @sina 1.0
 * @Description: 基于spring 注解实现 MyService Before advice 拦截，{@link MyAspect}
 */
public class SpringAopAnnotationDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MyAspect.class);
        context.refresh();
        MyService myService = context.getBean( MyService.class);
        myService.doSomething();
        context.close();
    }
}
