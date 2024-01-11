package com.github.bearboy.spring.databinder;

import com.github.bearboy.spring.ioc.overview.pojo.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValues;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

import java.util.HashMap;
import java.util.Map;

/**
 * 简单介绍使用DataBinder进行数据绑定
 * 数据绑定涉及：数据转换、属性赋值
 * 底层实现是通过beanWrapperImpl获取属性并通过反射来实现属性赋值，这个过程中涉及数据类型转换
 */
public class DataBinderDemo {
    public static void main(String[] args) {
        User user = new User();
        //创建要绑定的属性值
        Map<String,Object> map = new HashMap<>();
        map.putIfAbsent("age",18);
        map.put("name","bearboy90");
        //创建一个dataBinder
        DataBinder dataBinder = new DataBinder(user);
        PropertyValues propertyvalues = new MutablePropertyValues(map);
        //做属性绑定
        dataBinder.bind(propertyvalues);
        //获取绑定结果信息，如果有错误会在这里体现
        BindingResult result = dataBinder.getBindingResult();
        //打印绑定后的user
        System.out.println(user);
        //打印绑定结果
        System.out.println(result.getAllErrors());
    }
}
