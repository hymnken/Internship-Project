package com.kennyouchou.community.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kennyouchou.commons.QrCodeFactory.QrCodeFactory;
import com.kennyouchou.commons.enums.BooleanTypeEnum;
import com.kennyouchou.commons.enums.QrCodeColorEnum;
import com.kennyouchou.commons.pojo.QrCodeInfo;
import com.kennyouchou.commons.utils.BaseEntityUtil;
import com.kennyouchou.commons.utils.ShiroUtils;
import com.kennyouchou.community.entity.CommunityGreenCode;
import com.kennyouchou.community.entity.CommunityGreyCode;
import com.kennyouchou.community.entity.CommunityRedCode;
import com.kennyouchou.community.entity.CommunityYellowCode;
import com.kennyouchou.community.mapper.CommunityGreenCodeMapper;
import com.kennyouchou.community.service.CommunityGreenCodeService;
import com.kennyouchou.community.service.CommunityGreyCodeService;
import com.kennyouchou.community.service.CommunityRedCodeService;
import com.kennyouchou.community.service.CommunityYellowCodeService;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * 绿码用户关联表 服务实现类
 * </p>
 *
 * @author kennyouchou
 * @since 2022-10-13
 */
@Service
public class CommunityGreenCodeServiceImpl extends ServiceImpl<CommunityGreenCodeMapper, CommunityGreenCode> implements CommunityGreenCodeService {

    @Resource
    private CommunityRedCodeService communityRedCodeService;

    @Resource
    private CommunityYellowCodeService communityYellowCodeService;

    @Resource
    private CommunityGreyCodeService communityGreyCodeService;

    /**
     * 添加绿码用户关联，如果用户已经存在，则不添加
     *
     * @param communityGreenCode 用户绿码关联信息
     * @author kennyouchou
     * @since 2022/10/13 15:33
     **/
    @Override
    public void addGreenCode(CommunityGreenCode communityGreenCode) {
        // 判断用户是否存在
        LambdaQueryWrapper<CommunityGreenCode> greenWrapper = new LambdaQueryWrapper<>();
        greenWrapper.eq(CommunityGreenCode::getUserId, communityGreenCode.getUserId());
        if (super.count(greenWrapper) == 0) {
            super.save(communityGreenCode);
        }
    }

    /**
     * 根据用户id查询黄码
     *
     * @param userId 用户id
     * @return com.kennyouchou.community.entity.CommunityGreenCode
     * @author kennyouchou
     * @since 2022/10/14 8:40
     **/
    @Override
    public CommunityGreenCode findByUserId(String userId) {
        LambdaQueryWrapper<CommunityGreenCode> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(CommunityGreenCode::getUserId, userId)
                .eq(CommunityGreenCode::getIsEnable, BooleanTypeEnum.YES.getCode())
                .orderByDesc(CommunityGreenCode::getCreateTime);
        List<CommunityGreenCode> communityGreenCodeList = this.list(wrapper);
        return CollectionUtils.isNotEmpty(communityGreenCodeList) ? communityGreenCodeList.get(0) : null;
    }


    /**
     * 根据用户id得到二维码
     *
     * @param userId 用户id
     * @return java.awt.image.BufferedImage
     * @author kennyouchou
     * @since 2022/10/14 9:12
     **/
    @Override
    public BufferedImage getQrCodeByUserId(String userId) {
        // 构建用户信息
        Map<String, Object> result = new HashMap<>();
        result.put("用户Id", userId);
        result.put("用户名称", Objects.requireNonNull(ShiroUtils.getShiroUser()).getRealName());
        result.put("联系方式", Objects.requireNonNull(ShiroUtils.getShiroUser()).getMobil());
        result.put("固定电话", Objects.requireNonNull(ShiroUtils.getShiroUser()).getTel());

        /*
         * 优先级：
         *      红码 > 黄码 > 绿码 > 灰码
         * 优先级高的码，会覆盖优先级低的码
         **/
        // 查询红码
        CommunityRedCode redCode = communityRedCodeService.findByUserId(userId);
        if (ObjectUtils.isNotNull(redCode)) {
            result.put("健康码类型", QrCodeColorEnum.RED.getName());
            return QrCodeFactory.getQrCode(QrCodeColorEnum.RED, result);
        }
        // 查询黄码
        CommunityYellowCode yellowCode = communityYellowCodeService.findByUserId(userId);
        if (ObjectUtils.isNotNull(yellowCode)) {
            result.put("健康码类型", QrCodeColorEnum.YELLOW.getName());
            return QrCodeFactory.getQrCode(QrCodeColorEnum.YELLOW, result);
        }

        // 查询绿码
        CommunityGreenCode greenCode = this.findByUserId(userId);
        if (ObjectUtils.isNotNull(greenCode)) {
            result.put("健康码类型", QrCodeColorEnum.GREEN.getName());
            return QrCodeFactory.getQrCode(QrCodeColorEnum.GREEN, result);
        }

        // 查询灰码
        CommunityGreyCode greyCode = communityGreyCodeService.findByUserId(userId);
        if (ObjectUtils.isNotNull(greyCode)) {
            result.put("健康码类型", QrCodeColorEnum.GRAY.getName());
            return QrCodeFactory.getQrCode(QrCodeColorEnum.GRAY, result);
        }
        return null;
    }

    /**
     * 得到二维码信息
     *
     * @param userId 用户id
     * @return com.kennyouchou.commons.pojo.QrCodeInfo
     * @author kennyouchou
     * @since 2022/10/24 22:30
     **/
    @Override
    public QrCodeInfo getQrCodeInfoByUserId(String userId) {
        // 初始化二维码信息
        QrCodeInfo qrCodeInfo = new QrCodeInfo();
        qrCodeInfo.setUserId(userId);
        qrCodeInfo.setMobile(Objects.requireNonNull(ShiroUtils.getShiroUser()).getMobil());
        qrCodeInfo.setUserName(Objects.requireNonNull(ShiroUtils.getShiroUser()).getRealName());
        /*
         * 优先级：
         *      红码 > 黄码 > 绿码 > 灰码
         * 优先级高的码，会覆盖优先级低的码
         **/
        // 查询红码
        CommunityRedCode redCode = communityRedCodeService.findByUserId(userId);
        if (ObjectUtils.isNotNull(redCode)) {
            qrCodeInfo.setId(redCode.getId());
            qrCodeInfo.setCodeType(QrCodeColorEnum.RED.getValue());
            qrCodeInfo.setCodeTypeName(QrCodeColorEnum.RED.getName());
            return qrCodeInfo;
        }
        // 查询黄码
        CommunityYellowCode yellowCode = communityYellowCodeService.findByUserId(userId);
        if (ObjectUtils.isNotNull(yellowCode)) {
            qrCodeInfo.setId(yellowCode.getId());
            qrCodeInfo.setCodeType(QrCodeColorEnum.YELLOW.getValue());
            qrCodeInfo.setCodeTypeName(QrCodeColorEnum.YELLOW.getName());
            return qrCodeInfo;
        }

        // 查询绿码
        CommunityGreenCode greenCode = this.findByUserId(userId);
        if (ObjectUtils.isNotNull(greenCode)) {
            qrCodeInfo.setId(greenCode.getId());
            qrCodeInfo.setCodeType(QrCodeColorEnum.GREEN.getValue());
            qrCodeInfo.setCodeTypeName(QrCodeColorEnum.GREEN.getName());
            return qrCodeInfo;
        }

        // 查询灰码
        CommunityGreyCode greyCode = communityGreyCodeService.findByUserId(userId);
        if (ObjectUtils.isNotNull(greyCode)) {
            qrCodeInfo.setId(greyCode.getId());
            qrCodeInfo.setCodeType(QrCodeColorEnum.GRAY.getValue());
            qrCodeInfo.setCodeTypeName(QrCodeColorEnum.GRAY.getName());
            return qrCodeInfo;
        }
        return qrCodeInfo;
    }

    /**
     * 判断用户是否已经绑定绿码
     *
     * @param userId 用户id
     * @return java.lang.Boolean
     * @author kennyouchou
     * @since 2022/10/28 13:44
     **/
    @Override
    public Boolean isExist(String userId) {
        LambdaQueryWrapper<CommunityGreenCode> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(CommunityGreenCode::getUserId, userId)
                .eq(CommunityGreenCode::getIsEnable, BooleanTypeEnum.YES.getCode());
        return this.count(wrapper) > 0;
    }

    /**
     * 失效绿码
     *
     * @param userId 用户id
     * @author kennyouchou
     * @since 2022/10/28 13:56
     **/
    @Override
    public void invalidate(String userId) {
        CommunityGreenCode communityGreenCode = findByUserId(userId);
        if (ObjectUtils.isNull(communityGreenCode)) {
            return;
        }
        communityGreenCode.setIsEnable(BooleanTypeEnum.NO.getCode());
        BaseEntityUtil.edit(ShiroUtils.getUserId(), communityGreenCode);
        this.updateById(communityGreenCode);
    }

    /**
     * 如果用户之前为绿码或者灰码，则更新为黄码
     *
     * @param userId userId
     * @author kennyouchou
     * @since 2022/10/28 11:38
     **/
    @Override
    public void addRecord(String userId) {
        // 如果用户本身为红码或者黄码，则不做任何操作
        if (communityRedCodeService.isExist(userId) || communityYellowCodeService.isExist(userId)) {
            return;
        }
        // 添加黄码
        CommunityYellowCode communityYellowCode = new CommunityYellowCode();
        communityYellowCode.setUserId(userId);
        BaseEntityUtil.add(userId, communityYellowCode);
        communityYellowCodeService.save(communityYellowCode);
        // 失效绿码和灰码
        this.invalidate(userId);
        communityGreyCodeService.invalidate(userId);
    }

    /**
     * 失效所有健康码
     *
     * @param userId 用户id
     * @author kennyouchou
     * @since 2022/10/3 15:46
     **/
    @Override
    public void invalidateAll(String userId) {
        // 失效绿码
        this.invalidate(userId);
        // 失效灰码
        communityGreyCodeService.invalidate(userId);
        // 失效黄码
        communityYellowCodeService.invalidate(userId);
        // 失效红码
        communityRedCodeService.invalidate(userId);
    }

    /**
     * 转码
     *
     * @param userId   用户id
     * @param codeType 二维码类型
     * @author kennyouchou
     * @since 2022/10/4 1:37
     **/
    @Override
    public void changeCode(String userId, String codeType) {
        // 失效二维码
        this.invalidateAll(userId);
        // 添加二维码
        if (QrCodeColorEnum.RED.getValue().equals(codeType)) {
            CommunityRedCode communityRedCode = new CommunityRedCode();
            communityRedCode.setUserId(userId);
            BaseEntityUtil.add(ShiroUtils.getUserId(), communityRedCode);
            communityRedCodeService.save(communityRedCode);
        }else if (QrCodeColorEnum.YELLOW.getValue().equals(codeType)) {
            CommunityYellowCode communityYellowCode = new CommunityYellowCode();
            communityYellowCode.setUserId(userId);
            BaseEntityUtil.add(ShiroUtils.getUserId(), communityYellowCode);
            communityYellowCodeService.save(communityYellowCode);
        }else if (QrCodeColorEnum.GREEN.getValue().equals(codeType)) {
            CommunityGreenCode communityGreenCode = new CommunityGreenCode();
            communityGreenCode.setUserId(userId);
            BaseEntityUtil.add(ShiroUtils.getUserId(), communityGreenCode);
            this.save(communityGreenCode);
        }else if (QrCodeColorEnum.GRAY.getValue().equals(codeType)) {
            CommunityGreyCode communityGreyCode = new CommunityGreyCode();
            communityGreyCode.setUserId(userId);
            BaseEntityUtil.add(ShiroUtils.getUserId(), communityGreyCode);
            communityGreyCodeService.save(communityGreyCode);
        }
    }

    /**
     * 根据单元id查询数量
     *
     * @param unitId 单元id
     * @return int
     * @author kennyouchou
     * @since 2022/10/5 23:04
     **/
    @Override
    public int selectCountByUintId(String unitId) {
        return this.baseMapper.selectCountByUintId(unitId);
    }
}
