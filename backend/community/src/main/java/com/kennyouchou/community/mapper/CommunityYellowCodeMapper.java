package com.kennyouchou.community.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kennyouchou.community.entity.CommunityYellowCode;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 黄码用户关联表 Mapper 接口
 * </p>
 *
 * @author kennyouchou
 * @since 2022-10-20
 */
@Mapper
public interface CommunityYellowCodeMapper extends BaseMapper<CommunityYellowCode> {
    int selectCountByUintId(@Param("unitId") String unitId);
}
