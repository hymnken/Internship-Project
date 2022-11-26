package com.kennyouchou.author.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kennyouchou.author.entity.RoleResource;
import com.kennyouchou.author.mapper.RoleResourceMapper;
import com.kennyouchou.author.service.RoleResourceService;
import com.kennyouchou.author.vo.CommunityResourceVo;
import com.kennyouchou.commons.utils.BaseEntityUtil;
import com.kennyouchou.commons.utils.ShiroUtils;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 角色资源关联表 服务实现类
 * </p>
 *
 * @author kennyouchou
 * @since 2022-10-23
 */
@Service
public class RoleResourceServiceImpl extends ServiceImpl<RoleResourceMapper, RoleResource> implements RoleResourceService {

    /**
     * 根据角色id删除关联关系
     *
     * @param roleId 角色id
     * @author kennyouchou
     * @since 2022/11/5 2:20
     **/
    @Override
    public void deleteByRoleId(String roleId) {
        LambdaQueryWrapper<RoleResource> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(RoleResource::getRoleId, roleId);
        List<RoleResource> roleResourceList = this.list(wrapper);
        if (CollectionUtils.isNotEmpty(roleResourceList)){
            String userId = ShiroUtils.getUserId();
            List<RoleResource> deleteRoleResourceList = roleResourceList.stream().peek(item -> {
                BaseEntityUtil.delete(userId, item);
            }).collect(Collectors.toList());
            this.updateBatchById(deleteRoleResourceList);
            List<String> deleteRoleResourcesIds = deleteRoleResourceList.stream().map(RoleResource::getId).collect(Collectors.toList());
            this.removeByIds(deleteRoleResourcesIds);
        }
    }

    @Override
    public List<String> findUserPeriodId(String userId) {
        return this.baseMapper.findUserPeriodId(userId);
    }

    /**
     * 查询社区角色资源信息，根据角色id查询
     *
     * @param roleId 角色id
     * @return java.util.List<com.kennyouchou.author.vo.CommunityResourceVo>
     * @author kennyouchou
     * @since 2022/11/13 20:30
     **/
    @Override
    public List<CommunityResourceVo> findCommunityResourceByRoleId(String roleId) {
        return this.baseMapper.findCommunityResourceByRoleId(roleId);
    }
}
