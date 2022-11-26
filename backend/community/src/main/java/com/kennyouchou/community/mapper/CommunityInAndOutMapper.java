package com.kennyouchou.community.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kennyouchou.community.entity.CommunityInAndOut;

import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 小区-进出登记表 Mapper 接口
 * </p>
 *
 * @author kennyouchou
 * @since 2022-10-23
 */
@Mapper
public interface CommunityInAndOutMapper extends BaseMapper<CommunityInAndOut> {

}
