package com.github.bearboy.spring.bean.lifecycle;

import com.github.bearboy.spring.ioc.overview.pojo.User;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

/**
 * 实现InstantiationAwareBeanPostProcessor,
 * 通过postProcessBeforeInstantiation来控制bean实例化
 */
public class MyBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
    /**
     * 满足条件的beanName=“user-by-factory”,将会程序代码来创建一个新的对象
     * @param beanClass the class of the bean to be instantiated
     * @param beanName the name of the bean
     */
    @Override
    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        System.out.printf("实例化前操作：%s , %s \n", beanClass, beanName);
        //判断是否通过工厂方法来创建，如果是的话，直接创建一个新的user
        if ("user".equals(beanName) && beanClass.equals(User.class)) {
            User user = new User();
            user.setAge(18);
            user.setName("create from MyBeanPostProcessor");
            return user;
        } else {
            return null;
        }
    }

    @Override
    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        System.out.printf("实例化后操作：%s , %s \n", bean, beanName);
        return true;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.printf("初始化前操作：%s , %s \n", bean, beanName);
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.printf("初始化后操作：%s , %s \n", bean, beanName);
        return null;
    }
}
