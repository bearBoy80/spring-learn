package com.github.bearboy.spring.web.controller;

import com.github.bearboy.spring.web.vo.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @InitBinder
    public void initBinder(WebDataBinder binder){
    }
    @GetMapping("/echoHello")
    public String echoHello(@Validated User user, BindingResult result) {
        if (result.hasErrors()) {
            return "输入数据有问题";
        }
        return "say hello";
    }
}
