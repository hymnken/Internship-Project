package com.kennyouchou.community.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kennyouchou.community.entity.CommunityUnit;
import com.kennyouchou.community.vo.UnitVo;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 小区-单元 Mapper 接口
 * </p>
 *
 * @author kennyouchou
 * @since 2022-10-21
 */
@Mapper
public interface CommunityUnitMapper extends BaseMapper<CommunityUnit> {

    /**
     * 根据栋id查询社区信息
     * @param buildingId 栋Id
     * @return java.util.List<com.kennyouchou.community.vo.UnitVo>
     * @author kennyouchou
     * @since 2022/10/27 16:10
     **/
    List<UnitVo> findInfo(@Param("buildingId") String buildingId);

    int selectUnitIdUserCount(@Param("unitId") String unitId);

}
