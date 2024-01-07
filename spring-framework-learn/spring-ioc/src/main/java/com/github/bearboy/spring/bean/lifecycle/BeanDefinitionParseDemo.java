package com.github.bearboy.spring.bean.lifecycle;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;

/**
 * Bean解析
 * 关键代码：org.springframework.beans.factory.xml.XmlBeanDefinitionReader#loadBeanDefinitions(org.springframework.core.io.support.EncodedResource)
 */
public class BeanDefinitionParseDemo {
    public static void main(String[] args) {
        GenericApplicationContext context = new GenericApplicationContext();
        //加载xml并解析bean
        String location = "classpath:/META-INF/bean-Instantiation.xml";
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(context);
        int count = reader.loadBeanDefinitions(location);
        //刷新上下文
        context.refresh();
    }
}
