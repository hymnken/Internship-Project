package com.kennyouchou.community.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kennyouchou.community.entity.CommunityInAndOut;

import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 小区-进出登记表 服务类
 * </p>
 *
 * @author kennyouchou
 * @since 2022-10-13
 */
public interface CommunityInAndOutService extends IService<CommunityInAndOut> {

    /**
     * 添加社区进出登记
     * @param communityInAndOut  社区进出登记信息
     * @author kennyouchou
     * @since 2022/10/20 10:12
     **/
    @Transactional(rollbackFor = Exception.class)
    void addCommunityInAndOut(CommunityInAndOut communityInAndOut);

}
