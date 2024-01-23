package com.github.bearboy.spring.generic;

import org.springframework.core.ResolvableType;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author:bearBoy80
 * @date: 2024/1/23
 * @sina 1.0
 * @Description: 通过spring 提供ResolvableType来获取泛型参数　
 */
public class GenericDemo {
    public static void main(String[] args) throws Exception {
        ResolvableType resolvableType = ResolvableType.forType(HashMap.class);
        ResolvableType[] resolvableTypes = resolvableType.getGenerics();
        Arrays.stream(resolvableTypes).forEach(x-> System.out.println(x.getSource()));
        Method method = GenericDemo.class.getMethod("getGenericString");
        resolvableType = ResolvableType.forMethodReturnType(method);
        System.out.println(resolvableType.hasGenerics());
        //通过工厂方式创建一个resolvableType
        ResolvableType resolvableType1 = ResolvableType.forType(StringList.class);
        //获取泛型参数
        ResolvableType[] resolvableTypes1 = resolvableType1.getSuperType().getGenerics();
        //输出泛型
        Arrays.stream(resolvableTypes1).forEach(x-> System.out.println(x.getSource()));

    }
    public void getGenericString(){
        return;
    }
}
class StringList extends ArrayList<String>{

}
