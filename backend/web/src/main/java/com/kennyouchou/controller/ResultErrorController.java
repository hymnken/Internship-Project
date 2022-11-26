package com.kennyouchou.controller;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kennyouchou.commons.result.Result;

/**
 *
 * 返回异常控制器
 *
 *
 * @author kennyouchou
 * @since 2022-11-01 16:16:08
 */
@RestController
public class ResultErrorController {

    @RequestMapping("/shiroError")
    public void error(){
        throw new AuthorizationException();
    }
}
