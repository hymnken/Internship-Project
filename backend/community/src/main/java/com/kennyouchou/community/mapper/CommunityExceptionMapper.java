package com.kennyouchou.community.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kennyouchou.community.bo.QueryExceptionBo;
import com.kennyouchou.community.entity.CommunityException;
import com.kennyouchou.community.vo.ExceptionVo;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 社区异常表 Mapper 接口
 * </p>
 *
 * @author kennyouchou
 * @since 2022-10-22
 */
@Mapper
public interface CommunityExceptionMapper extends BaseMapper<CommunityException> {

    /**
     * 查询异常信息
     * @param queryExceptionBo  查询条件
     * @return com.kennyouchou.community.vo.ExceptionVo
     * @author kennyouchou
     * @since 2022/10/22 15:52
     **/
    List<ExceptionVo> findList(QueryExceptionBo queryExceptionBo);

}
