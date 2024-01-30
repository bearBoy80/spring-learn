package com.github.bearboy.web.mvc;

import com.github.bearboy.biz.api.ApiRequest;
import com.github.bearboy.biz.api.ApiResponse;
import com.github.bearboy.biz.api.interfaces.UserRegistrationRestService;
import com.github.bearboy.biz.api.model.User;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:bearBoy80
 * @date: 2024/1/30
 * @sina 1.0
 * @Description:
 */
@RestController
public class UserRegistrationRestController implements UserRegistrationRestService {
    @Override
    public ApiResponse<Boolean> registerUser(ApiRequest<User> userRequest) {
        return ApiResponse.ok(Boolean.TRUE);
    }

    @Override
    public ApiResponse<Boolean> registerUser(User user) {
        return ApiResponse.ok(Boolean.TRUE);
    }
}
