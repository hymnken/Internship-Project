package com.kennyouchou.controller;


import com.kennyouchou.commons.result.Result;
import com.kennyouchou.factory.MyExceptionFactory;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * 全局异常处理器
 *
 *
 * @author kennyouchou
 * @since 2022-11-09 14:08:02
 */
@RestControllerAdvice
public class ExceptionController {


    /**
     * 全局异常处理
     * @param request request上下文
     * @param e 异常信息
     * @return com.kennyouchou.shiro_boot02.vo.Result
     * @author kennyouchou
     * @since 2022/11/09 11:03
     **/
    @ExceptionHandler(Exception.class)
    public Result<Object> defaultExceptionHandler(HttpServletRequest request, Exception e){
        // 异常方法
        String requestMethod = request.getMethod();
        return MyExceptionFactory.getResult(e, requestMethod);
    }
}