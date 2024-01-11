package com.github.bearboy.spring.validation;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Iterator;
import java.util.Set;

/**
 * 基于ApplicationContext来实现java bean validator
 * 注意@Validated 必须添加到类级别上去，不然校验不会生效。
 * 因为基于AOP来实现@Validated校验，具体实现类见{@link MethodValidationPostProcessor}
 */
public class ApplicationContextValidatorDemo {
    public static void main(String[] args) {
        String location = "classpath:/META-INF/bean-validator.xml";
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
        context.setConfigLocation(location);
        //刷新容器
        context.refresh();
        Person person = new Person();
        LocalValidatorFactoryBean bean = (LocalValidatorFactoryBean) context.getBean("validatorFactoryBean");
        Set<ConstraintViolation<Person>> constraintViolations = bean.getValidator().validate(person);
        if (!constraintViolations.isEmpty()) {
            for (Iterator<ConstraintViolation<Person>> it = constraintViolations.iterator(); it.hasNext(); ) {
                ConstraintViolation constraintViolation = it.next();
                System.out.println(constraintViolation.getPropertyPath() + constraintViolation.getMessage());
            }
        }
        PersonProcessor personProcessor = context.getBean(PersonProcessor.class);
        try {
            personProcessor.process(person);
        }catch (Exception e){
            e.printStackTrace();
        }

        personProcessor.validateName("");
        //关闭容器
        context.close();
    }
}
@Component
@Validated
class PersonProcessor{

    /**
     * 方法上面添加valid提示要验证person
     * @param person
     */
    void process(@Valid Person person){
        System.out.println(person);
    }
    void validateName(@NotBlank String name){
        System.out.println("valid name value:"+name);
    }
}
