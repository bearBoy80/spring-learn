package com.github.bearboy.spring.bean;

import com.github.bearboy.spring.ioc.overview.pojo.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 如果不指定beanName，默认会调用{@link BeanNameGenerator} 实现类来创建beanName
 * 本案例默认是AnnotationBeanNameGenerator来实现自动重命名beanName
 */
public class BeanNameGenerateDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //person 作为一个组件被注册到容器中，默认beanName=person
        context.register(Person.class);

        BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        builder.addPropertyValue("age", 18).addPropertyValue("name", "a beautiful girl");
        //通过非命名方式注册bean到容器中
        BeanDefinitionReaderUtils.registerWithGeneratedName(builder.getBeanDefinition(), context);
        context.refresh();
        System.out.println(context.getBeansOfType(Person.class));
        System.out.println(context.getBeansOfType(User.class));
    }

}

@Component
class Person {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
