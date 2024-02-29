package com.github.bearboy.spring.event;

import org.springframework.context.ApplicationListener;

public class MySpringEventListener implements ApplicationListener<MySpringEvent> {
    @Override
    public void onApplicationEvent(MySpringEvent event) {
        System.out.println("线程id:" + Thread.currentThread().getName() +" MySpringEventListener处理：" + event);
    }
}
