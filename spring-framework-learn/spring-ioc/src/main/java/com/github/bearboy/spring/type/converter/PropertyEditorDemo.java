package com.github.bearboy.spring.type.converter;

import java.beans.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 实现字符串日期转date,
 * 前置需要熟悉java beans 规范
 */
public class PropertyEditorDemo extends PropertyEditorSupport {
    @Override
    public String getAsText() {
        Date date = (Date) getValue();
        LocalDate localDate = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).toLocalDate();
        return localDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        LocalDate localDate = LocalDate.parse(text, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        setValue(date);
    }

    public static void main(String[] args) {
        try {
           BeanInfo beanInfo =  Introspector.getBeanInfo(Person.class);
           PropertyEditorDemo propertyEditorDemo = new PropertyEditorDemo();
           propertyEditorDemo.setAsText("2030-11-12");
           System.out.println(propertyEditorDemo.getAsText());
        } catch (IntrospectionException e) {
            throw new RuntimeException(e);
        }
    }
}
