package com.github.bearboy.spring.resources;

import org.springframework.core.io.ClassPathResource;
import org.springframework.validation.annotation.Validated;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 通过ClassPathResource来读取ioc-view.xml，并打印xml文件内容
 */
public class SpringResourcesDemo {
    public static void main(String[] args) {
        //classpath 查找资源
        ClassPathResource resource = new ClassPathResource("/META-INF/ioc-view.xml");
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
