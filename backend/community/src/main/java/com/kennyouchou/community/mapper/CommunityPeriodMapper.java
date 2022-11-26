package com.kennyouchou.community.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kennyouchou.community.entity.CommunityPeriod;
import com.kennyouchou.community.vo.AddressVo;
import com.kennyouchou.community.vo.CascadeVo;
import com.kennyouchou.community.vo.ComprehensiveVo;
import com.kennyouchou.community.vo.PeriodVo;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 小区-期 Mapper 接口
 * </p>
 *
 * @author kennyouchou
 * @since 2022-10-23
 */
@Mapper
public interface CommunityPeriodMapper extends BaseMapper<CommunityPeriod> {

    /**
     * 根据期id得到小区信息
     * @param id  期Id
     * @return java.util.List<com.kennyouchou.community.vo.PeriodVo>
     * @author kennyouchou
     * @since 2022/10/26 18:34
     **/
    List<PeriodVo> findCommunityByPeriodId(@Param("id") String id);

    /**
     * 根据期id得到小区信息
     * @return java.util.List<com.kennyouchou.community.vo.PeriodVo>
     * @author kennyouchou
     * @since 2022/10/26 18:34
     **/
    List<CascadeVo> findCommunityAllInfo();

    /**
     *  根据期id得到小区户信息
     * @param id 期id
     * @return java.util.List<com.kennyouchou.community.vo.PeriodVo>
     * @author kennyouchou
     * @since 2022/10/26 19:12
     **/
    List<ComprehensiveVo> findComprehensiveByPeriodId(@Param("id") String id);


    /**
     * 获取当前登录人的住址信息
     * @param userId 用户id
     * @return AddressVo
     * @author kennyouchou
     * @since 2022/10/29 21:24
     **/
    AddressVo findInfoByUser(@Param("userId") String userId);

    /**
     * 查询登录用户是否含有住址信息
     * @return 房间状态
     * @author kennyouchou
     * @since 2022/10/26 16:12
     **/
    Integer checkUserHasAddress(@Param("userId") String userId);


}
