package com.kennyouchou.factory;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.session.UnknownSessionException;

import com.kennyouchou.commons.enums.ResultCodeEnum;
import com.kennyouchou.commons.result.Result;
import com.kennyouchou.commons.result.impl.ErrorResult;

/**
 *
 * 异常简易处理工厂
 *
 *
 * @author kennyouchou
 * @since 2022-11-12 13:26:02
 */
@Slf4j
public class MyExceptionFactory {

    public static Result<Object> getResult(Exception e, String methodName){
        log.error(e.getMessage(), e);
        if (e instanceof UnknownAccountException){
            return new ErrorResult<>(ResultCodeEnum.NO_LOGIN.getCode(), "用户不存在");
        }else if (e instanceof IncorrectCredentialsException){
            return new ErrorResult<>(ResultCodeEnum.NO_LOGIN.getCode(), "用户名或密码错误");
        }else if (e instanceof AuthorizationException){
            return new ErrorResult<>(ResultCodeEnum.NO_AUTHORITY.getCode(), "权限不足");
        }else if (e instanceof UnknownSessionException) {
            return new ErrorResult<>(ResultCodeEnum.NO_LOGIN.getCode(), "请重新登录！");
        } else{
            return new ErrorResult<>(ResultCodeEnum.OTHER.getCode(), e.getMessage(), e);
        }
    }

}