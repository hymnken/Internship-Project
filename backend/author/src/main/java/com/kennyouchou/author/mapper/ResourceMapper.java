package com.kennyouchou.author.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kennyouchou.author.entity.Resource;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 资源表 Mapper 接口
 * </p>
 *
 * @author kennyouchou
 * @since 2022-10-23
 */
@Mapper
public interface ResourceMapper extends BaseMapper<Resource> {

    /**
     * 根据用户id查询用户拥有的资源ids
     * @param userId 用户id
     * @return java.util.List<java.lang.String>
     * @author kennyouchou
     * @since 2022/10/24 9:37
     **/
    List<Resource> getResourcesByUserId(@Param("userId") String userId);

}
