package com.github.bearboy.spring.validation;

import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

import java.util.Locale;
import java.util.Objects;

/**
 * 基于spring validator实现对应自定义验证
 */
public class SpringValidatorDemo {
    public static void main(String[] args) {
        Person user = new Person();
        PersonValidator validator = new PersonValidator();
        Errors errors = new BindException(user,"person");
        validator.validate(user,errors);
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("information");
        messageSource.setDefaultEncoding("utf-8");
        if (errors.hasErrors()){
            for (ObjectError error: errors.getAllErrors()){
                String message = messageSource.getMessage(Objects.requireNonNull(error.getCode()),error.getArguments(), Locale.getDefault());
                System.out.println(message);
            }
        }
    }
}
