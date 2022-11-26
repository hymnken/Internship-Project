package com.kennyouchou.community.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kennyouchou.community.entity.CommunityTemperatureRegistration;

import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 小区-体温登记表 Mapper 接口
 * </p>
 *
 * @author kennyouchou
 * @since 2022-10-13
 */
@Mapper
public interface CommunityTemperatureRegistrationMapper extends BaseMapper<CommunityTemperatureRegistration> {

}
