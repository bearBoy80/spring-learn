package com.github.bearboy.spring.bean.lifecycle;

import com.github.bearboy.spring.ioc.overview.pojo.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.beans.factory.support.RootBeanDefinition;

public class MyMergedBeanDefinitionPostProcessor implements MergedBeanDefinitionPostProcessor {
    @Override
    public void postProcessMergedBeanDefinition(RootBeanDefinition beanDefinition, Class<?> beanType, String beanName) {
        if (beanType.equals(User.class)){
            MutablePropertyValues propertyValues = beanDefinition.getPropertyValues();
            propertyValues.add("name","from mergeBeanDefinition");
        }
    }
}
