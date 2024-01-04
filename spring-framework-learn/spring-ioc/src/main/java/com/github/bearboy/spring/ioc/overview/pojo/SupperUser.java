package com.github.bearboy.spring.ioc.overview.pojo;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class SupperUser extends User implements InitializingBean {
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SupperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        this.setAddress("上海");
        this.setAge(18);
        this.setName("bearBoy");
    }
}
