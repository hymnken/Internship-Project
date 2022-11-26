package com.kennyouchou.community.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kennyouchou.community.entity.CommunityGreenCode;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 绿码用户关联表 Mapper 接口
 * </p>
 *
 * @author kennyouchou
 * @since 2022-10-22
 */
@Mapper
public interface CommunityGreenCodeMapper extends BaseMapper<CommunityGreenCode> {

    int selectCountByUintId(@Param("unitId") String unitId);

}
