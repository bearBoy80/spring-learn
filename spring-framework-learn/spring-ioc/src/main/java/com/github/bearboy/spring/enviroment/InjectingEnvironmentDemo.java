package com.github.bearboy.spring.enviroment;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.Environment;

/**
 * Environment 依赖注入和查找
 */
public class InjectingEnvironmentDemo implements EnvironmentAware, ApplicationContextAware {

    private Environment environment1;

    @Autowired
    private Environment environment2;

    private Environment environment3;
    private ApplicationContext applicationContext;

    @Override
    public void setEnvironment(Environment environment) {
        this.environment1 = environment;
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(InjectingEnvironmentDemo.class);
        context.refresh();
        InjectingEnvironmentDemo demo = context.getBean(InjectingEnvironmentDemo.class);
        //判断environment11、environment2、environment3 是否都相等
        System.out.println("environment1 equal environment2 :" + (demo.environment1 == demo.environment2));
        System.out.println("environment2 equal environment3 :" + (demo.environment2 == demo.environment3));
        //关闭容器
        context.close();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
        this.environment3 = applicationContext.getEnvironment();
    }
}
