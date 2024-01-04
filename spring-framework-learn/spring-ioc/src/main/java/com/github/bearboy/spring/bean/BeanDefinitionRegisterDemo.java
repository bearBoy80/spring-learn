package com.github.bearboy.spring.bean;

import com.github.bearboy.spring.ioc.overview.pojo.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 将BeanDefinition注册到spring容器中
 * 通过编码方式创建一个User bean实例
 */
public class BeanDefinitionRegisterDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(User.class);

        builder.addPropertyValue("age",18).addPropertyValue("name","a beautiful girl");
        context.registerBeanDefinition("bean-definition-user",builder.getBeanDefinition());
        context.refresh();
        System.out.println(context.getBean("bean-definition-user"));
    }
}
