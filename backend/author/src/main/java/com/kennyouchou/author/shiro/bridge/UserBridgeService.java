package com.kennyouchou.author.shiro.bridge;

import com.kennyouchou.author.entity.User;
import com.kennyouchou.commons.pojo.ShiroUser;

import org.apache.shiro.authz.AuthorizationInfo;

import java.util.List;

/**
 * <p>
 *  用户信息桥接
 * </p>
 *
 * @author kennyouchou
 * @date 2022-10-24 09:19:54
 */
public interface UserBridgeService {

    /**
     * 根据用户登录名查找用户
     * @param loginName 登录名称
     * @return com.kennyouchou.author.entity.User
     * @author kennyouchou
     * @since 2022/10/24 9:21
     **/
    User findUserByLoginName(String loginName);

    /**
     * 根据用户id得到用户拥有的资源id
     * @param userId 用户id
     * @return java.util.List<java.lang.String>
     * @author kennyouchou
     * @since 2022/10/24 9:30
     **/
    List<String> findResourceIds(String userId);


    /**
     * 根据用户id的到用户角色信息
     * @param userId  用户id
     * @return java.util.List<java.lang.String>
     * @author kennyouchou
     * @since 2022/10/31 14:00
     **/
    List<String> findRoleIds(String userId);


    /**
     * 得到鉴权信息
     * @param shiroUser shiro用户对象
     * @return org.apache.shiro.authz.AuthorizationInfo 鉴权信息
     * @author kennyouchou
     * @since 2022/10/24 10:01
     **/
    AuthorizationInfo getAuthorizationInfo(ShiroUser shiroUser);

    /**
     * 登录成后加载缓存信息
     * @param shiroUser 登录信息
     * @author kennyouchou
     * @since 2022/1/14 15:39
     **/
    void loadUserAuthorityToCache(ShiroUser shiroUser);

    /**
     * 查询用户对应角色标识list
     * @param userId 用户id
     * @return 角色标识集合
     */
    List<String> findRoleList(String key,String userId);

    /**
     * 查询用户对应资源标识list
     * @param userId 用户id
     * @return 资源标识集合
     */
    List<String> findResourcesList(String key,String userId);

}
