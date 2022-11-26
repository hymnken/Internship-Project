package com.kennyouchou.community.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.kennyouchou.community.entity.CommunityBuilding;

import java.util.List;

/**
 * <p>
 * 小区-栋 服务类
 * </p>
 *
 * @author kennyouchou
 * @since 2022-10-01
 */
public interface CommunityBuildingService extends IService<CommunityBuilding> {

    /**
     * 添加栋信息
     * @param building 栋信息
     * @return CommunityBuilding
     * @author kennyouchou
     * @since 2022/10/4 15:31
     **/
    CommunityBuilding add(CommunityBuilding building);

    /**
     * 查询栋
     * @param parentId 父级id
     * @return java.util.List<com.kennyouchou.community.entity.CommunityPeriod>
     * @author kennyouchou
     * @since 2022/10/4 17:05
     **/
    List<CommunityBuilding> find(String parentId);

    /**
     * 查询所有栋
     * @return java.util.List<com.kennyouchou.community.entity.CommunityBuilding>
     * @author kennyouchou
     * @since 2022/10/5 19:43
     **/
    List<CommunityBuilding> findAll();

    /**
     * 分页查询期下的所有栋
     * @param periodId 期id
     * @param pageNum 起始页
     * @param pageSize 页面大小
     * @return java.util.List<com.kennyouchou.community.entity.CommunityBuilding>
     * @author kennyouchou
     * @since 2022/10/7 15:14
     **/
    PageInfo<CommunityBuilding> findAllByPeriodId(String periodId, Integer pageNum, Integer pageSize);




}
