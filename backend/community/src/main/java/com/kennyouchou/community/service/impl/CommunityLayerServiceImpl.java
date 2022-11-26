package com.kennyouchou.community.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kennyouchou.commons.enums.BooleanTypeEnum;
import com.kennyouchou.commons.utils.BaseEntityUtil;
import com.kennyouchou.commons.utils.ShiroUtils;
import com.kennyouchou.community.entity.CommunityLayer;
import com.kennyouchou.community.mapper.CommunityLayerMapper;
import com.kennyouchou.community.service.CommunityLayerService;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 小区-层 服务实现类
 * </p>
 *
 * @author kennyouchou
 * @since 2022-10-01
 */
@Service
public class CommunityLayerServiceImpl extends ServiceImpl<CommunityLayerMapper, CommunityLayer> implements CommunityLayerService {

    /**
     * 添加层信息
     *
     * @param layer 层信息
     * @return CommunityBuilding
     * @author kennyouchou
     * @since 2022/10/4 15:31
     **/
    @Override
    public CommunityLayer add(CommunityLayer layer) {
        BaseEntityUtil.add(ShiroUtils.getShiroUser().getId(), layer);
        this.baseMapper.insert(layer);
        return layer;
    }

    /**
     * 查询层
     *
     * @param parentId 父级id
     * @return java.util.List<com.kennyouchou.community.entity.CommunityPeriod>
     * @author kennyouchou
     * @since 2022/10/4 17:05
     **/
    @Override
    public List<CommunityLayer> find(String parentId) {
        LambdaQueryWrapper<CommunityLayer> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(CommunityLayer::getCreateUser, ShiroUtils.getShiroUser().getId())
                .eq(CommunityLayer::getUnitId, parentId)
                .eq(CommunityLayer::getIsEnable, BooleanTypeEnum.YES.getCode())
                .orderByAsc(CommunityLayer::getSortNo);
        return this.baseMapper.selectList(wrapper);
    }
}
