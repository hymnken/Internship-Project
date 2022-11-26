package com.kennyouchou.author.shiro.utils;

import cn.hutool.core.util.ObjectUtil;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.util.ThreadContext;

import com.kennyouchou.commons.pojo.ShiroUser;
import com.kennyouchou.commons.utils.ShiroUtils;

/**
 * <p>
 * shiro用户工具类
 * </p>
 *
 * @author kennyouchou
 * @since 2022-10-13 13:53:46
 */
public class ShiroUserUtils extends ShiroUtils {

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

}
