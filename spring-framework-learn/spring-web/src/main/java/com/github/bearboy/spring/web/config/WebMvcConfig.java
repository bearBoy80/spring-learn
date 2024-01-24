package com.github.bearboy.spring.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author:bearBoy80
 * @date: 2024/1/24
 * @sina 1.0
 * @Description:
 */
@Configuration(proxyBeanMethods = false)
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> handlers) {
        System.out.println(handlers);
    }
}
