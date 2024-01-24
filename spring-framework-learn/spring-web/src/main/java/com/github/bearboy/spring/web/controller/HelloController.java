package com.github.bearboy.spring.web.controller;

import com.github.bearboy.spring.web.config.StringToDatePropertyEditor;
import com.github.bearboy.spring.web.vo.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class HelloController {
    //局部添加自定义PropertyEditor
    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Date.class,new StringToDatePropertyEditor());
    }
    @GetMapping("/echoHello")
    public String echoHello(@Validated User user, BindingResult result) {
        if (result.hasErrors()) {
            return "输入数据有问题";
        }
        return "say hello";
    }
}
