package com.kennyouchou.community.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kennyouchou.commons.enums.BooleanTypeEnum;
import com.kennyouchou.commons.utils.BaseEntityUtil;
import com.kennyouchou.commons.utils.ShiroUtils;
import com.kennyouchou.community.entity.CommunityYellowCode;
import com.kennyouchou.community.mapper.CommunityYellowCodeMapper;
import com.kennyouchou.community.service.CommunityGreyCodeService;
import com.kennyouchou.community.service.CommunityRedCodeService;
import com.kennyouchou.community.service.CommunityYellowCodeService;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 黄码用户关联表 服务实现类
 * </p>
 *
 * @author kennyouchou
 * @since 2022-10-20
 */
@Service
public class CommunityYellowCodeServiceImpl extends ServiceImpl<CommunityYellowCodeMapper, CommunityYellowCode> implements CommunityYellowCodeService {


    @Resource
    private CommunityGreyCodeService communityGreyCodeService;

    @Resource
    private CommunityRedCodeService communityRedCodeService;


    /**
     * 根据用户id查询黄码
     *
     * @param userId 用户id
     * @return com.kennyouchou.community.entity.CommunityRedCode
     * @author kennyouchou
     * @since 2022/10/14 8:40
     **/
    @Override
    public CommunityYellowCode findByUserId(String userId) {
        LambdaQueryWrapper<CommunityYellowCode> yellowWrapper = new LambdaQueryWrapper<>();
        yellowWrapper.eq(CommunityYellowCode::getUserId, userId)
                .eq(CommunityYellowCode::getIsEnable, BooleanTypeEnum.YES.getCode())
                .orderByDesc(CommunityYellowCode::getCreateTime);
        List<CommunityYellowCode> communityYellowCodeList = this.list(yellowWrapper);
        return CollectionUtils.isNotEmpty(communityYellowCodeList) ? communityYellowCodeList.get(0) : null;
    }



    /**
     * 判断用户是否已经绑定黄码
     *
     * @param userId 用户id
     * @return java.lang.Boolean
     * @author kennyouchou
     * @since 2022/10/28 13:44
     **/
    @Override
    public Boolean isExist(String userId) {
        LambdaQueryWrapper<CommunityYellowCode> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(CommunityYellowCode::getUserId, userId)
                .eq(CommunityYellowCode::getIsEnable, BooleanTypeEnum.YES.getCode());
        return this.count(wrapper) > 0;
    }

    /**
     * 失效黄码
     *
     * @param userId 用户id
     * @author kennyouchou
     * @since 2022/10/28 13:56
     **/
    @Override
    public void invalidate(String userId) {
        CommunityYellowCode communityYellowCode = findByUserId(userId);
        if (ObjectUtils.isEmpty(communityYellowCode)) {
            return;
        }
        communityYellowCode.setIsEnable(BooleanTypeEnum.NO.getCode());
        BaseEntityUtil.edit(ShiroUtils.getUserId(), communityYellowCode);
        this.updateById(communityYellowCode);
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
