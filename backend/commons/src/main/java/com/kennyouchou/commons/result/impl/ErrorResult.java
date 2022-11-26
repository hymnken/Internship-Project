package com.kennyouchou.commons.result.impl;

import com.kennyouchou.commons.enums.ResultEnum;
import com.kennyouchou.commons.result.Result;

/**
 * <p>
 * 异常结果统一封装类
 * </p>
 *
 * @author kennyouchou
 * @since 2022-10-28 09:40:16
 */
public class ErrorResult<T> extends Result<T> {
    public ErrorResult(){
        super(ResultEnum.ERROR.getCode(), ResultEnum.ERROR.getValue());
    }

    public ErrorResult(String message){
        super(ResultEnum.ERROR.getCode(), message);
    }

    public ErrorResult(Integer code, String message){
        super(code, message);
    }

    public ErrorResult(Integer code, String message, T data){
        super(code, message, data);
    }

    public ErrorResult(T data){
        super(ResultEnum.ERROR.getCode(), ResultEnum.ERROR.getValue(), data);
    }
}
