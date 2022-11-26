package com.kennyouchou.commons.result.impl;

import com.kennyouchou.commons.enums.ResultEnum;
import com.kennyouchou.commons.result.Result;

/**
 * <p>
 * 成功结果统一封装类
 * </p>
 *
 * @author kennyouchou
 * @since 2022-10-28 09:40:16
 */
public class SuccessResult<T> extends Result<T> {
    public SuccessResult(){
        super(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getValue());
    }

    public SuccessResult(String message){
        super(ResultEnum.SUCCESS.getCode(), message);
    }

    public SuccessResult(Integer code, String message){
        super(code, message);
    }

    public SuccessResult(Integer code, String message, T data){
        super(code, message, data);
    }

    public SuccessResult(String message, T data){
        super(ResultEnum.SUCCESS.getCode(), message, data);
    }

    public SuccessResult(T data){
        super(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getValue(), data);
    }
}
