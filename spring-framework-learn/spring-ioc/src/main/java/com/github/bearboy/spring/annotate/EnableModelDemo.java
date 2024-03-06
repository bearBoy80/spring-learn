package com.github.bearboy.spring.annotate;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

/**
 * Enable模块化 demo
 * 自定义实现Enable模块的方式有三种
 * - 通过Configuration Class 实现
 * - @see ImportSelector 方式
 * - @see ImportBeanDefinitionRegistrar 方式
 *
 */
@EnableHello
public class EnableModelDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(EnableModelDemo.class);
        context.refresh();
        context.close();
    }
}
