package com.github.bearboy.spring.bean.lifecycle;


import com.github.bearboy.spring.ioc.overview.pojo.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.Properties;

/**
 * 利用MergedBeanDefinitionPostProcessor提供回调来实现动态调整User属性值
 * 具体代码见{@link MyMergedBeanDefinitionPostProcessor}
 */
@PropertySource("/META-INF/user.properties")
public class MergeBeanDefinitionDemo {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(MergeBeanDefinitionDemo.class);
        MutablePropertySources mutablePropertySources = context.getEnvironment().getPropertySources();
        Properties properties = new Properties();
        ClassPathResource resource = new ClassPathResource("META-INF/user.properties");
        properties.load(resource.getInputStream());
        mutablePropertySources.addFirst(new PropertiesPropertySource("userProperties", properties));
        context.getBeanFactory().addBeanPostProcessor(new MyMergedBeanDefinitionPostProcessor());
        context.refresh();
        System.out.println(context.getBean("user"));
    }

    @Bean
    public User user(@Value("${user.id}") int id, @Value("${user.name}") String name) {
        User user = new User();
        user.setAge(id);
        user.setName(name);
        System.out.printf("实例化user属性:age:%d name: %s \n", id, name);
        return user;
    }
}
