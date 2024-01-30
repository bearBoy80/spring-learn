package com.github.bearboy.biz.api.interfaces;

import com.github.bearboy.biz.api.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@FeignClient("${user.service.name}") // user // user-login user-registration
@RequestMapping("/user")
@Deprecated
public interface UserService {

    @PostMapping("/register")
    Boolean registerUser(User user);

    @PostMapping("/login")
    @Deprecated
    User login(Map<String, Object> context);
}