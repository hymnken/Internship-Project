package com.kennyouchou.community.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.kennyouchou.community.entity.CommunityTemperatureRegistration;

import org.springframework.transaction.annotation.Transactional;

import java.awt.image.BufferedImage;

/**
 * <p>
 * 小区-体温登记表 服务类
 * </p>
 *
 * @author kennyouchou
 * @since 2022-10-13
 */
public interface CommunityTemperatureRegistrationService extends IService<CommunityTemperatureRegistration> {

    /**
     * 添加一条体温记录信息
     * @param communityTemperatureRegistration  体温登记信息
     * @author kennyouchou
     * @since 2022/10/12 15:59
     **/
    @Transactional(rollbackFor = Exception.class)
    void add(CommunityTemperatureRegistration communityTemperatureRegistration);

    /**
     * 查看当前登陆人连续打卡天数
     * @return java.lang.Integer
     * @author kennyouchou
     * @since 2022/10/20 22:03
     **/
    Integer continuousDay();

    /**
     * 获得当前登录人的二维码
     * @return java.awt.image.BufferedImage
     * @author kennyouchou
     * @since 2022/10/5 22:06
     **/
    BufferedImage getQrcode();

    /**
     * 查询打卡记录
     * @param pageNum  页码
     * @param pageSize 页码大小
     * @param isEnable  是否作废
     * @param isHealth 是否健康
     * @return com.github.pagehelper.PageInfo<com.kennyouchou.community.entity.CommunityTemperatureRegistration>
     * @author kennyouchou
     * @since 2022/10/6 2:39
     **/
    PageInfo<CommunityTemperatureRegistration> findList(Integer pageNum, Integer pageSize, Integer isEnable, Integer isHealth);

}
