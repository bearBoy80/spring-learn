package com.github.bearboy.spring.enviroment;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.PropertySource;

/**
 * 通过application.property来调整动态创建不同的bean
 */
@PropertySource("/META-INF/application.property")
public class ApplicationPropertySourceDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(ApplicationPropertySourceDemo.class);

        context.refresh();

        context.close();
    }
    @Bean("odd")
    @Conditional(OddPropertyValueCondition.class)
    public String odd(@Value("${even}") String odd){
        System.out.println("通过property获取奇数" + odd);
        return odd;
    }
    @Bean
    @Conditional(EvenPropertyValueCondition.class)
    public String even(@Value("${even}") String even){
        System.out.println("通过property获取偶数:" + even);
        return even;
    }
}
