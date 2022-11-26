package com.kennyouchou.author.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kennyouchou.author.entity.UserRole;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 用户角色关联表 服务类
 * </p>
 *
 * @author kennyouchou
 * @since 2022-10-23
 */
public interface UserRoleService extends IService<UserRole> {

    /**
     * 角色绑定
     * @param userId 用户id
     * @param roleIds 角色id
     * @author kennyouchou
     * @since 2022/11/8 19:20
     **/
    @Transactional(rollbackFor = Exception.class)
    void bind(String userId, List<String> roleIds);

    /**
     * 激活角色
     * @param userId 用户id
     * @param label 角色标签
     * @author kennyouchou
     * @since 2022/11/9 18:01
     **/
    void activeRole(String userId, String... label);

    /**
     * 根据角色id删除关联关系
     * @param roleId 角色id
     * @author kennyouchou
     * @since 2022/11/10 2:15
     **/
    @Transactional(rollbackFor = Exception.class)
    void deleteByRoleId(String roleId);


    /**
     * 查询用户角色信息
     * @param userId userId
     * @param label  角色标签
     * @return java.util.List<com.kennyouchou.author.entity.UserRole>
     * @author kennyouchou
     * @since 2022/11/15 15:17
     **/
    List<UserRole> findUserRole(String userId, String label);
}
