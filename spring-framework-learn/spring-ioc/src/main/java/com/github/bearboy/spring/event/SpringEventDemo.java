package com.github.bearboy.spring.event;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Spring eventListener 实现方式有三种
 * 1.通过spring bean 方式
 * 2.通过ConfigurableApplicationContext.addApplicationListener
 * 3.通过注解方式@EventListener
 */
public class SpringEventDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        ConfigurableApplicationContext applicationContext = (ConfigurableApplicationContext) context;
        applicationContext.addApplicationListener(new ApplicationListener<ApplicationEvent>() {
            @Override
            public void onApplicationEvent(ApplicationEvent event) {
                println("收到事件："+event);
            }
        });
        //启动容器并refresh
        context.refresh();
        //关闭容器
        context.close();
    }
    public static void println(Object object){
        System.out.println(object);
    }
}
