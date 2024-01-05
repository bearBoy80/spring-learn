package com.github.bearboy.spring.bean;

import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * bean初始化
 * spring 容器提供三种方式的实现bean的初始化回调
 * - 实现InitializingBean
 * - 注解PostConstruct，需要依赖javax.annotation-api
 * - @Bean(initMethod) 指定初始化方法
 * 注意执行顺序是注解PostConstruct > XXXAware接口 > InitializingBean >  @Bean(initMethod)
 * PostConstruct注解是通过CommonAnnotationBeanPostProcessor来实现
 * XXXAware接口 > InitializingBean >  @Bean(initMethod)
 * 都是在{@link AbstractAutowireCapableBeanFactory}#initializeBean进行逻辑处理
 **/
public class BeanInitializingDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(UserConfig.class);
        context.refresh();
    }

}
