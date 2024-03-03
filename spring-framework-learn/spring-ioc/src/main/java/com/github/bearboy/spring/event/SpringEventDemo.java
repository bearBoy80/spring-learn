package com.github.bearboy.spring.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;


/**
 * Spring eventListener 实现方式有三种
 * 1.通过spring bean 方式
 * 2.通过ConfigurableApplicationContext.addApplicationListener
 * 3.通过注解方式@EventListener
 */
@EnableAsync
public class SpringEventDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        ConfigurableApplicationContext applicationContext = (ConfigurableApplicationContext) context;
        applicationContext.addApplicationListener(new ApplicationListener<ApplicationEvent>() {
            @Override
            public void onApplicationEvent(ApplicationEvent event) {
                println("收到事件：" + event);
            }
        });
        context.register(SpringEventDemo.class);
        context.register(MyListener.class);
        //启动容器并refresh
        context.refresh();
        //发布start事件
        context.start();
        //关闭容器
        context.close();
    }

    public static void println(Object object) {
        System.out.println(object);
    }
    @Async
    @EventListener({ContextStartedEvent.class, ContextRefreshedEvent.class})
    public void AnnotationMyListener(ApplicationEvent event){
        System.out.printf("异步线程名称- %s,异步处理：" +
                event,Thread.currentThread().getName());
    }
}
class  MyListener implements ApplicationListener<ApplicationEvent>{

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        System.out.println("MyListener " + event);
    }
}
