package com.kennyouchou.author.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.kennyouchou.author.bo.AddRoleBo;
import com.kennyouchou.author.entity.Resource;
import com.kennyouchou.author.entity.Role;
import com.kennyouchou.author.entity.User;
import com.kennyouchou.author.vo.CommunityRoleVo;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 用户角色表 服务类
 * </p>
 *
 * @author kennyouchou
 * @since 2022-10-23
 */
public interface RoleService extends IService<Role> {

    /**
     * 根据用户信息得到用户权限信息
     * @param user 用户信息
     * @return java.util.List<com.kennyouchou.author.entity.Role>
     * @author kennyouchou
     * @since 2022/10/24 13:49
     **/
    List<Role>  findRoleListByUser(User user);

    /**
     * 根据用户id得到用户角色Ids
     * @param userId 用户id
     * @return java.util.List<java.lang.String>
     * @author kennyouchou
     * @since 2022/10/24 13:53
     **/
    List<String> findRoleIdsByUserId(String userId);

    /**
     * 根据用户的id得到角色信息
     * @param userId 用户id
     * @return java.util.List<com.kennyouchou.author.entity.Role>
     * @author kennyouchou
     * @since 2022/10/31 14:46
     **/
    List<Role> findRoleByUserId(String userId);

    /**
     * 查询当前用户资源
     * @return java.util.List<com.kennyouchou.author.entity.Resource>
     * @author kennyouchou
     * @since 2022/10/31 17:18
     **/
    List<Resource> findCurrentUserFunction();


    /**
     * 根据角色类型查询角色信息
     * @param label  角色标签
     * @return Role
     * @author kennyouchou
     * @since 2022/11/4 17:49
     **/
    List<Role> findRoleIdByLabel( String... label);

    /**
     * 添加社区管理角色
     * @param addRoleBo 社区管理角色信息
     * @author kennyouchou
     * @since 2022/11/4 23:51
     **/
    @Transactional(rollbackFor = Exception.class)
    void editCommunityRole(AddRoleBo addRoleBo);

    /**
     * 查询社区管理角色
     * @param pageNum   页码
     * @param pageSize  每页数量
     * @param name    角色名称
     * @author kennyouchou
     * @since 2022/11/5 0:41
     *
     **/
    PageInfo<CommunityRoleVo> findCommunityRole(Integer pageNum, Integer pageSize, String name);

    /**
     * 删除角色
     * @param id 角色id
     * @author kennyouchou
     * @since 2022/11/5 2:08
     **/
    @Transactional(rollbackFor = Exception.class)
    void deleteRole(String id);

    /**
     * 编辑用户社区角色形象
     * @param userId 用户ids
     * @param roleIds 角色ids
     * @author kennyouchou
     * @since 2022/11/5 15:03
     **/
    @Transactional(rollbackFor = Exception.class)
    void editUserRole(String userId, List<String> roleIds);
}
