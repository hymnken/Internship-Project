package com.kennyouchou.community.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kennyouchou.community.entity.CommunityUnit;
import com.kennyouchou.community.vo.InfoVo;

import java.util.List;

/**
 * <p>
 * 小区-单元 服务类
 * </p>
 *
 * @author kennyouchou
 * @since 2022-10-01
 */
public interface CommunityUnitService extends IService<CommunityUnit> {

    /**
     * 添加栋信息
     * @param unit 栋信息
     * @return CommunityUnit
     * @author kennyouchou
     * @since 2022/10/4 15:31
     **/
    CommunityUnit add(CommunityUnit unit);

    /**
     * 查询栋
     * @param parentId 父级id
     * @return List<CommunityUnit>
     * @author kennyouchou
     * @since 2022/10/4 17:05
     **/
    List<CommunityUnit> find(String parentId);

    /**
     * 根据栋id查询单元详情
     * @param buindingId 栋id
     * @return java.util.List<com.kennyouchou.community.vo.InfoVo>
     * @author kennyouchou
     * @since 2022/10/7 15:51
     **/
    List<InfoVo> findInfo(String buindingId);

    /**
     * 查询单元内人口
     * @param unitId 单元id
     * @return int
     * @author kennyouchou
     * @since 2022/10/5 22:55
     **/
    int selectBuildingUserCount(String unitId);
}
