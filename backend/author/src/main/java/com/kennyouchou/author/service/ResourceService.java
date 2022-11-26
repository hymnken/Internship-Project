package com.kennyouchou.author.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kennyouchou.author.entity.Resource;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 资源表 服务类
 * </p>
 *
 * @author kennyouchou
 * @since 2022-10-23
 */
public interface ResourceService extends IService<Resource> {

    /**
     * 根据用户id查询用户拥有的资源ids
     * @param userId 用户id
     * @return java.util.List<java.lang.String>
     * @author kennyouchou
     * @since 2022/10/24 9:37
     **/
    List<String> getResourceIdsByUserId(String userId);

    /**
     * 根据用户id得到资源信息
     * @param userId 用户id
     * @return java.util.List<com.kennyouchou.author.entity.Resource>
     * @author kennyouchou
     * @since 2022/10/31 14:35
     **/
    List<Resource> getResourceByUserId(String userId);

    /**
     * 添加社区资源
     * @param periodId 期ids
     * @author kennyouchou
     * @since 2022/11/1 0:09
     **/
    @Transactional(rollbackFor = Exception.class)
    void addCommunityResource(String roleId, List<String> periodId);
}
