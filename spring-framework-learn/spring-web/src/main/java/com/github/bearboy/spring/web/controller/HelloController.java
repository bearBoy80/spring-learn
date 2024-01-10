package com.github.bearboy.spring.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/echoHello")
    public String echoHello(){
        return "say hello";
    }
}
