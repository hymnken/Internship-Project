package com.kennyouchou.community.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kennyouchou.community.entity.CommunityRedCode;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 红码用户关联表 Mapper 接口
 * </p>
 *
 * @author kennyouchou
 * @since 2022-10-13
 */
@Mapper
public interface CommunityRedCodeMapper extends BaseMapper<CommunityRedCode> {
    int selectCountByUintId(@Param("unitId") String unitId);
}
