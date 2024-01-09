package com.github.bearboy.spring.i8n;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;

public class SpringI8NDemo {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-i8n.xml",
                SpringI8NDemo.class);
        String message = context.getMessage("message", null,
                "Default", Locale.getDefault());
        System.out.println(message);
        context.refresh();
        System.out.println(SpringI8NDemo.class.getClassLoader().getResource("."));
        //jdk messageFormat
        String formatPattern ="At {1,time} on {1,date}, there was {2} on planet {0,number,integer}";
        String  result = MessageFormat.format(formatPattern, 2, new Date(), "event");
        System.out.println(result);
    }
}
