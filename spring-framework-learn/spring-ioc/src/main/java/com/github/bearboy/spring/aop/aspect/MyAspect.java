package com.github.bearboy.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author:bearBoy80
 * @date: 2024/1/25
 * @sina 1.0
 * @Description: 开启aspectj注解、定义一个aspect
 */
@Configuration(proxyBeanMethods = false)
@ComponentScan("com.github.bearboy.spring.aop.service")
@EnableAspectJAutoProxy
@Aspect
public class MyAspect {
    @Pointcut("execution( * com.github.bearboy.spring.aop.service.*.doSome*())")
    public void myPointCut(){}
    @Before(value = "myPointCut() && target(targetObj)")
    public void beforeAdvice(Object targetObj){
        System.out.println("before "+ targetObj);
    }
}
