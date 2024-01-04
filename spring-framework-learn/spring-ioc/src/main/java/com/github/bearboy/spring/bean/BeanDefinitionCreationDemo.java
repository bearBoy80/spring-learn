package com.github.bearboy.spring.bean;

import com.github.bearboy.spring.ioc.overview.pojo.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.GenericBeanDefinition;

/**
 * 演示怎么创建一个BeanDefinition的创建及相关属性使用
 * - 通过BeanDefinitionBuilder
 * - 通过GenericBeanDefinition
 * - 自己实现AbstractBeanDefinition来实现自定义beanDefinition
 */
public class BeanDefinitionCreationDemo {
    public static void main(String[] args) {
        BeanDefinitionBuilder builder = getDefinitionBuilder();
        System.out.println(builder.getBeanDefinition());
        System.out.println(getGenericBeanDefinition());
    }

    private static BeanDefinitionBuilder getDefinitionBuilder() {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition();
        builder.getRawBeanDefinition().setBeanClass(User.class);
        builder.addPropertyValue("age", 23);
        builder.addPropertyValue("name", "bearboy80");
        return builder;
    }

    private static BeanDefinition getGenericBeanDefinition() {
        GenericBeanDefinition definition = new GenericBeanDefinition();
        definition.setBeanClass(User.class);
        MutablePropertyValues propertyValues = new MutablePropertyValues();
        propertyValues.add("age", 25)
                .add("name", "bearboy80");
        definition.setPropertyValues(propertyValues);
        return definition;
    }
}
