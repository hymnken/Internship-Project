package com.kennyouchou.community.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kennyouchou.community.bo.QueryUserHouseholdBo;
import com.kennyouchou.community.entity.CommunityHouseholdUser;
import com.kennyouchou.community.vo.UserHouseholdVo;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户与户关联表 Mapper 接口
 * </p>
 *
 * @author kennyouchou
 * @since 2022-10-22
 */
@Mapper
public interface CommunityHouseholdUserMapper extends BaseMapper<CommunityHouseholdUser> {

    /**
     * 查询住户信息
     * @param queryUserHouseholdBo 查询条件
     * @return java.util.List<com.kennyouchou.community.vo.UserHouseholdVo>
     * @author kennyouchou
     * @since 2022/10/25 21:54
     **/
    List<UserHouseholdVo> findUserHoseholdByQuery(QueryUserHouseholdBo queryUserHouseholdBo);

    String findPeriodIdByUserId(@Param("userId") String userId);

    void  updateUserPeriod(@Param("userId") String userId, @Param("periodId") String periodId);

    List<String> findUserPeriodId(String userId);

}
