package com.github.bearboy.spring.annotate;

import com.github.bearboy.spring.ioc.overview.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class BeanAnnotationDemo {
    @Autowired(required = false)
    private User user;

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(BeanAnnotationDemo.class);
        context.refresh();
        BeanAnnotationDemo annotationDemo = context.getBean(BeanAnnotationDemo.class);
        System.out.println(annotationDemo.getUser());
    }

    /**
     * 定义User bean
     * @param  name ：user name
     * @return 返回值 user 对象
     */
    @Bean(autowireCandidate = false,
            value = ConfigurableBeanFactory.SCOPE_SINGLETON,
            initMethod = "init",destroyMethod = "destroyMethod")
    public User user(@Value("${user.name}") String name) {
        User user = new User();
        user.setName(name);
        user.setAge(34);
        return user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
