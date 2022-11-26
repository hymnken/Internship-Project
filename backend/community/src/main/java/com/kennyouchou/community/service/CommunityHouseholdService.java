package com.kennyouchou.community.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kennyouchou.community.entity.CommunityHousehold;

import java.util.List;

/**
 * <p>
 * 小区-户 服务类
 * </p>
 *
 * @author kennyouchou
 * @since 2022-10-01
 */
public interface CommunityHouseholdService extends IService<CommunityHousehold> {
    /**
     * 添加层信息
     * @param household 层信息
     * @return CommunityBuilding
     * @author kennyouchou
     * @since 2022/10/4 15:31
     **/
    CommunityHousehold add(CommunityHousehold household);
    /**
     * 查询层
     * @param parentId 父级id
     * @return java.util.List<com.kennyouchou.community.entity.CommunityPeriod>
     * @author kennyouchou
     * @since 2022/10/4 17:05
     **/
    List<CommunityHousehold> find(String parentId);
    String findPeriodIByHouseholdId(String householdId);
}
