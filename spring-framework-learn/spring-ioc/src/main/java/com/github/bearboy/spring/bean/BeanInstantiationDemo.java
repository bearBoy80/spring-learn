package com.github.bearboy.spring.bean;

import com.github.bearboy.spring.ioc.overview.pojo.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

/**
 * 通过
 */
public class BeanInstantiationDemo {
    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();
        //定一个xmlBeanDefinition解析器
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        String location = "classpath:/META-INF/bean-Instantiation.xml";
        reader.loadBeanDefinitions(location);
        //编码方式注册beanDefinition到容器里面
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(User.class);

        builder.addPropertyValue("age", 18).addPropertyValue("name", "a beautiful girl");

        BeanDefinitionReaderUtils.registerWithGeneratedName(builder.getBeanDefinition(), context);
        //刷新容器
        context.refresh();

        System.out.println(context.getBeansOfType(User.class));
        //关闭容器
        context.close();
    }
}
