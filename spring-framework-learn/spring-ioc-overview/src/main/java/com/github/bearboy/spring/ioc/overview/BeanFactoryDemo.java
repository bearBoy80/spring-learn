package com.github.bearboy.spring.ioc.overview;

import com.github.bearboy.spring.ioc.overview.pojo.User;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * BeanFactory 提供spring ioc 容器的基础能力（配置信息和对象管理），
 * ApplicationContext 在beanFactory之上构建企业级服务，比如事件、i8n、aop等
 * The BeanFactory interface provides
 * an advanced configuration mechanism capable of managing any type of object.
 * ApplicationContext is a sub-interface of BeanFactory. It adds:
 * Easier integration with Spring’s AOP features
 * Message resource handling (for use in internationalization)
 * Event publication
 * Application-layer specific contexts such as the WebApplicationContext for use in web applications.
 */

/**
 * BeanFactory demo 展示
 * 1、创建一个beanFactory 实力
 * 2、创建一个XmlBeanDefinitionReader来读取bean定义文件
 * 3、通过依赖查找方式来实现创建一个user 对象
 */
public class BeanFactoryDemo {
    public static void main(String[] args) {
        String location = "classpath:/META-INF/ioc-view.xml";
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        int beanCount = reader.loadBeanDefinitions(location);
        System.out.println("加载bean总数" + beanCount);
        System.out.println(factory.getBean(User.class));
    }
}
