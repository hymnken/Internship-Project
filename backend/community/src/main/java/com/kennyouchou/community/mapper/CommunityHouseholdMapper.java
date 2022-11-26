package com.kennyouchou.community.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kennyouchou.community.entity.CommunityHousehold;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 小区-户 Mapper 接口
 * </p>
 *
 * @author kennyouchou
 * @since 2022-10-22
 */
@Mapper
public interface CommunityHouseholdMapper extends BaseMapper<CommunityHousehold> {

    String findPeriodIByHouseholdId(@Param("householdId") String householdId);
}
