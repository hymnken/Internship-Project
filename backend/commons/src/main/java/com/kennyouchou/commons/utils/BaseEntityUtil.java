package com.kennyouchou.commons.utils;

import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.UUID;

import com.kennyouchou.commons.enums.BooleanTypeEnum;


/**
 * 操作数据工具类
 *
 * @author kennyouchou
 * @since 2022/10/4 15:58
 **/
@Slf4j
public class BaseEntityUtil {

    public static Object add(String userId, Object object){
        Class objectClass = object.getClass();
        try{
            objectClass.getDeclaredMethod("setId",String.class).invoke(object, UUID.randomUUID().toString());
            objectClass.getDeclaredMethod("setCreateUser",String.class).invoke(object,userId);
            objectClass.getDeclaredMethod("setCreateTime", LocalDateTime.class).invoke(object,LocalDateTime.now());
            objectClass.getDeclaredMethod("setIsEnable", Integer.class).invoke(object, BooleanTypeEnum.YES.getCode());
            objectClass.getDeclaredMethod("setIsDelete", Integer.class).invoke(object, BooleanTypeEnum.NO.getCode());
        }catch (Exception e){
            log.error(e.toString(),e);
        }
        return object;
    }

    public static Object edit(String userId, Object object){
        Class objectClass = object.getClass();
        try{
            objectClass.getDeclaredMethod("setUpdateUser",String.class).invoke(object,userId);
            objectClass.getDeclaredMethod("setUpdateTime", LocalDateTime.class).invoke(object,LocalDateTime.now());
        }catch (Exception e){
            log.error(e.toString(),e);
        }
        return object;
    }

    public static Object delete(String userId, Object object){
        Class objectClass = object.getClass();
        try{
            objectClass.getDeclaredMethod("setDeleteUser",String.class).invoke(object,userId);
            objectClass.getDeclaredMethod("setDeleteTime", LocalDateTime.class).invoke(object,LocalDateTime.now());
        }catch (Exception e){
            log.error(e.toString(),e);
        }
        return object;
    }

}
