package com.github.bearboy.spring.enviroment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

import java.util.HashMap;
import java.util.Map;

/**
 * 动态调整配置属性源
 */
public class EnvironmentPropertySourceChangeDemo {
    //无法动态调整
    @Value("${user.name}")
    private String userName;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(EnvironmentPropertySourceChangeDemo.class);
        //容器刷新前调整user.name
        MutablePropertySources propertySources = context.getEnvironment().getPropertySources();
        Map<String, Object> source = new HashMap<>();
        source.put("user.name", "bearboy80");
        MapPropertySource propertySource = new MapPropertySource("first-property-source", source);
        propertySources.addFirst(propertySource);
        context.refresh();
        EnvironmentPropertySourceChangeDemo demo = context.getBean(EnvironmentPropertySourceChangeDemo.class);
        //获取userName
        System.out.println(demo.userName);
        //调整propertySource的属性
        source.put("user.name", "007");
        EnvironmentPropertySourceChangeDemo demo1 = context.getBean(EnvironmentPropertySourceChangeDemo.class);
        System.out.println(demo1.userName);
        for (PropertySource ps : propertySources) {
            System.out.printf("PropertySource(name=%s) 'user.name' 属性：%s\n", ps.getName(), ps.getProperty("user.name"));
        }
        //关闭容器
        context.close();
    }
}
