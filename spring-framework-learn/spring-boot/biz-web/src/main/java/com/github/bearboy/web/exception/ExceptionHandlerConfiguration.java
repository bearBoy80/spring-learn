package com.github.bearboy.web.exception;

import com.github.bearboy.biz.api.ApiResponse;
import jakarta.validation.ValidationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author:bearBoy80
 * @date: 2024/1/30
 * @sina 1.0
 * @Description: 定义全局拦截
 */
@RestControllerAdvice
public class ExceptionHandlerConfiguration {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResponse<Void> onValidationException(MethodArgumentNotValidException e) {
        return ApiResponse.failed(null, e.getMessage());
    }
}
