package com.github.bearboy.spring.type.converter;

import org.springframework.core.convert.converter.Converter;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 实现字符串日期转date,
 * 前置需要熟悉java beans 规范
 */
public class StringToDateConverter extends PropertyEditorSupport implements Converter<String, Date> {
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
            BeanInfo beanInfo = Introspector.getBeanInfo(Person.class);
            StringToDateConverter propertyEditorDemo = new StringToDateConverter();
            propertyEditorDemo.setAsText("2030-11-12");
            System.out.println(propertyEditorDemo.getAsText());
        } catch (IntrospectionException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Date convert(String source) {
        LocalDate localDate = LocalDate.parse(source, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
}
