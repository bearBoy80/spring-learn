package com.github.bearboy.spring.bean.lifecycle;

import com.github.bearboy.spring.ioc.overview.pojo.User;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

/**
 * bean 实例化前阶段
 */
public class BeanBeforeInstantiationDemo {
    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();
        //加载xml并解析bean
        String location = "classpath:/META-INF/bean-life-cycle.xml";
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        context.getBeanFactory().addBeanPostProcessor(new MyBeanPostProcessor());
        int count = reader.loadBeanDefinitions(location);
        //刷新上下文
        context.refresh();
        System.out.println(context.getBeansOfType(User.class));
    }
}
