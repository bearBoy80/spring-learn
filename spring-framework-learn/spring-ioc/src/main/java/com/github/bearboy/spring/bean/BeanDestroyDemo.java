package com.github.bearboy.spring.bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * bean初始化
 * spring 容器提供三种方式的实现bean的销毁回调
 * - 实现DisposableBean
 * - @PreDestroy，需要依赖javax.annotation-api
 * - @Bean(destroyMethod) 指定初始化方法
 * 注意执行顺序是注解PreDestroy > DisposableBean >  @Bean(destroyMethod)
 * PostConstruct注解是通过CommonAnnotationBeanPostProcessor来实现
 * DisposableBean >  @Bean(destroyMethod)
 * 都是在 @see DisposableBeanAdapter#destroy()进行逻辑处理
 **/
class BeanDestroyDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(UserConfig.class);
        context.refresh();
        System.out.println("开始关闭context-------------");
        context.close();
    }

}
