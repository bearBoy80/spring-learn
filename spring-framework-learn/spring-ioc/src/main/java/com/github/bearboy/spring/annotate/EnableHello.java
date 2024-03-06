package com.github.bearboy.spring.annotate;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
//@Import(HelloWorldConfiguration.class)
//@Import(HelloWorldImportSelector.class)
@Import(HelloWorldBeanDefinitonImportSelector.class)
public @interface EnableHello {
}
