package com.kennyouchou.community.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kennyouchou.community.entity.CommunityRedCode;

/**
 * <p>
 * 红码用户关联表 服务类
 * </p>
 *
 * @author kennyouchou
 * @since 2022-10-13
 */
public interface CommunityRedCodeService extends IService<CommunityRedCode> {

    /**
     * 判断用户是否在红码表中
     * @param userId  用户id
     * @return java.lang.Boolean
     * @author kennyouchou
     * @since 2022/10/14 8:40
     **/
    Boolean isExist(String userId);


    /**
     * 根据用户id查询红码
     * @param userId 用户id
     * @return com.kennyouchou.community.entity.CommunityRedCode
     * @author kennyouchou
     * @since 2022/10/14 8:40
     **/
    CommunityRedCode findByUserId(String userId);

    /**
     * 失效红码
     * @param userId 用户id
     * @author kennyouchou
     * @since 2022/10/28 13:56
     **/
    void invalidate(String userId);

    /**
     * 根据单元id查询数量
     * @param unitId 单元id
     * @return int
     * @author kennyouchou
     * @since 2022/10/25 23:04
     **/
    int selectCountByUintId(String unitId);

}
