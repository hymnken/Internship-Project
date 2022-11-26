package com.kennyouchou.author.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kennyouchou.author.entity.RoleResource;
import com.kennyouchou.author.vo.CommunityResourceVo;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 角色资源关联表 服务类
 * </p>
 *
 * @author kennyouchou
 * @since 2022-10-23
 */
public interface RoleResourceService extends IService<RoleResource> {

    /**
     * 根据角色id删除关联关系
     * @param roleId 角色id
     * @author kennyouchou
     * @since 2022/11/5 2:20
     **/
    @Transactional(rollbackFor = Exception.class)
    void deleteByRoleId(String roleId);

    List<String> findUserPeriodId(String userId);

    /**
     * 查询社区角色资源信息，根据角色id查询
     * @param roleId  角色id
     * @return java.util.List<com.kennyouchou.author.vo.CommunityResourceVo>
     * @author kennyouchou
     * @since 2022/11/13 20:30
     **/
    List<CommunityResourceVo> findCommunityResourceByRoleId(String roleId);
}
