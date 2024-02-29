package com.github.bearboy.spring.event;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.util.ReflectionUtils;

import javax.annotation.PostConstruct;
import java.lang.reflect.Field;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.springframework.context.support.AbstractApplicationContext.APPLICATION_EVENT_MULTICASTER_BEAN_NAME;

/**
 * 通过ApplicationEventMulticaster、ApplicationEventPublisher来发送事件
 * 通过ApplicationEventPublisher 本质还是借助ApplicationEventMulticaster来实现实现发送
 */
public class SpringEventPublisherDemo implements ApplicationEventPublisherAware, ApplicationContextAware {

    @Autowired
    private ApplicationEventMulticaster applicationEventMulticaster;

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        applicationEventPublisher.publishEvent("hello spring event");
    }

    @PostConstruct
    public void init() {
        //将事件同步切换到异步
        if (applicationEventMulticaster instanceof SimpleApplicationEventMulticaster) {
            SimpleApplicationEventMulticaster multicaster = (SimpleApplicationEventMulticaster) applicationEventMulticaster;
            ExecutorService taskExecutor = Executors.newSingleThreadExecutor();
            multicaster.setTaskExecutor(taskExecutor);
        }
        //# 3
        applicationEventMulticaster.multicastEvent(new MySpringEvent("The event from @Autowired ApplicationEventPublisher"));
        // #4
        applicationContext.publishEvent(new MySpringEvent("The event from @Autowired ApplicationContext"));

    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(SpringEventPublisherDemo.class);
        context.addApplicationListener(new MySpringEventListener());
        context.addApplicationListener(new ApplicationListener<PayloadApplicationEvent>() {
            //为啥这个在主线程执行的原因是，发布事件的时候，SimpleApplicationEventMulticaster还未从同步切换到异步
            @Override
            public void onApplicationEvent(PayloadApplicationEvent event) {
                System.out.println("线程id:" + Thread.currentThread().getName() + " PayloadApplicationEvent 事件处理：" + event);
            }
        });
        context.addApplicationListener(new ApplicationListener<ContextClosedEvent>() {
            @Override
            public void onApplicationEvent(ContextClosedEvent event) {
                SimpleApplicationEventMulticaster multicaster = (SimpleApplicationEventMulticaster) context.getBeanFactory().getBean(APPLICATION_EVENT_MULTICASTER_BEAN_NAME,
                        ApplicationEventMulticaster.class);
                Field field = ReflectionUtils.findField(SimpleApplicationEventMulticaster.class, "taskExecutor");
                field.setAccessible(true);
                try {
                    ExecutorService executor = (ExecutorService) field.get(multicaster);
                    if (!executor.isShutdown()) {
                        executor.shutdown();
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        context.refresh();
        context.close();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        //this.applicationContext = applicationContext;
    }
}
