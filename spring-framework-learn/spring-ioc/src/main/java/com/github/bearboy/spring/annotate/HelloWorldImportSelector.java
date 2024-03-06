package com.github.bearboy.spring.annotate;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class HelloWorldImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.github.bearboy.spring.annotate.HelloWorldConfiguration"};
    }
}
