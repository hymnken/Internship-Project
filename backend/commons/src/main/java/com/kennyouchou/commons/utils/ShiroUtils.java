package com.kennyouchou.commons.utils;

import cn.hutool.core.util.ObjectUtil;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.util.ThreadContext;

import com.kennyouchou.commons.pojo.ShiroUser;

import java.util.Objects;

/**
 * <p>
 * shiro工具类
 * </p>
 *
 * @author kennyouchou
 * @since 2022-10-31 13:41:04
 */
public class ShiroUtils {

    /**
     * 得到shiro session对象
     * @return org.apache.shiro.session.Session
     * @author kennyouchou
     * @since 2022/10/31 13:44
     **/
    public static Session getSession(){
        return SecurityUtils.getSubject().getSession();
    }

    /**
     * 得到shiro的sessionId
     * @return java.lang.String
     * @author kennyouchou
     * @since 2022/10/31 13:45
     **/
    public static String getSessionId(){
        return getSession().getId().toString();
    }


    /**
     * 判断是否登录
     * @return boolean
     * @author kennyouchou
     * @since 2022/10/31 13:46
     **/
    public static boolean isAuthenticated(){
        return SecurityUtils.getSubject().isAuthenticated();
    }

    /**
     * 得到shiroUser对象
     * @return com.kennyouchou.author.shiro.pojo.ShiroUser
     * @author kennyouchou
     * @since 2022/10/13 13:55
     **/
    public static ShiroUser getShiroUser(){
        if (ObjectUtil.isNotEmpty(ThreadContext.getSubject()) && ObjectUtil.isNotEmpty(ThreadContext.getSubject().getPrincipal())){
            return (ShiroUser)SecurityUtils.getSubject().getPrincipal();
        }
        return null;
    }


    /**
     * 得到UserId
     * @return com.kennyouchou.author.shiro.pojo.ShiroUser
     * @author kennyouchou
     * @since 2022/10/13 13:55
     **/
    public static String getUserId(){
        ShiroUser shiroUser = getShiroUser();
        if (! Objects.isNull(shiroUser)){
            return shiroUser.getId();
        }
        return null;
    }
}
