package com.kennyouchou.commons.annotation.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kennyouchou.commons.annotation.entity.Log;

import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 日志表 Mapper 接口
 * </p>
 *
 * @author kennyouchou
 * @since 2022-10-23
 */
@Mapper
public interface LogMapper extends BaseMapper<Log> {

}
