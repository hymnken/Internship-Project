package com.kennyouchou.community.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kennyouchou.commons.enums.BooleanTypeEnum;
import com.kennyouchou.commons.utils.BaseEntityUtil;
import com.kennyouchou.commons.utils.ShiroUtils;
import com.kennyouchou.community.entity.CommunityUnit;
import com.kennyouchou.community.mapper.CommunityUnitMapper;
import com.kennyouchou.community.service.*;
import com.kennyouchou.community.vo.*;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 小区-单元 服务实现类
 * </p>
 *
 * @author kennyouchou
 * @since 2022-10-01
 */
@Service
public class CommunityUnitServiceImpl extends ServiceImpl<CommunityUnitMapper, CommunityUnit> implements CommunityUnitService {

    @Resource
    private CommunityGreenCodeService communityGreenCodeService;

    @Resource
    private CommunityGreyCodeService communityGreyCodeService;

    @Resource
    private CommunityYellowCodeService communityYellowCodeService;

    @Resource
    private CommunityRedCodeService communityRedCodeService;

    /**
     * 添加栋信息
     *
     * @param unit 栋信息
     * @return CommunityUnit
     * @author kennyouchou
     * @since 2022/10/4 15:31
     **/
    @Override
    public CommunityUnit add(CommunityUnit unit) {
        BaseEntityUtil.add(ShiroUtils.getShiroUser().getId(), unit);
        this.baseMapper.insert(unit);
        return unit;
    }

    /**
     * 查询栋
     *
     * @param parentId 父级id
     * @return List<CommunityUnit>
     * @author kennyouchou
     * @since 2022/10/4 17:05
     **/
    @Override
    public List<CommunityUnit> find(String parentId) {
        LambdaQueryWrapper<CommunityUnit> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(CommunityUnit::getCreateUser, ShiroUtils.getShiroUser().getId())
                .eq(CommunityUnit::getBuildingId, parentId)
                .eq(CommunityUnit::getIsEnable, BooleanTypeEnum.YES.getCode())
                .orderByAsc(CommunityUnit::getSortNo);
        return this.baseMapper.selectList(wrapper);
    }

    /**
     * 根据栋id查询单元详情
     *
     * @param buindingId 栋id
     * @return java.util.List<com.kennyouchou.community.vo.InfoVo>
     * @author kennyouchou
     * @since 2022/10/7 15:51
     **/
    @Override
    public List<InfoVo> findInfo(String buindingId) {
        List<UnitVo> unitVoList = this.baseMapper.findInfo(buindingId);
        ArrayList<InfoVo> infoVoList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(unitVoList)){
            List<UnitVo> sortUnitList = unitVoList.stream().sorted(Comparator.comparing(UnitVo::getSortNo)).collect(Collectors.toList());
            sortUnitList.forEach(unit -> {
                InfoVo infoVo = new InfoVo();
                infoVo.setUnitId(unit.getId());
                infoVo.setUnitNumber(unit.getUnitNumber());
                List<LayerVo> layerVoList = unit.getLayerVoList();
                if(CollectionUtils.isNotEmpty(layerVoList)){
                    layerVoList.forEach(layerVo -> {
                        List<HouseholdVo> householdVoList = layerVo.getHouseholdVoList();
                        if (CollectionUtils.isNotEmpty(householdVoList)){
                            if (! CollectionUtils.isEmpty(householdVoList)){
                                // 户信息不为空
                                infoVo.setAllHousehold(householdVoList.size());
                                List<Integer> sizeList = householdVoList.stream().map(h -> {
                                    int size = 0;
                                    List<HouseholdUserVo> householdUserVoList = h.getHouseholdUserVoList();
                                    if (CollectionUtils.isEmpty(householdUserVoList)) {
                                        // 用户不为空
                                        size = householdUserVoList.size();
                                    }
                                    return size;
                                }).collect(Collectors.toList());
                                int userSize = sizeList.stream().mapToInt(s -> s).sum();
                                infoVo.setAllUser(userSize);
                            }
                        }
                    });
                }
                if (! ObjectUtils.isEmpty(infoVo.getUnitId())) {
                    // 人口,红码，黄码，绿码，灰码
                    infoVo.setAllUser(this.selectBuildingUserCount(infoVo.getUnitId()));
                    infoVo.setGreenCode(communityGreenCodeService.selectCountByUintId(infoVo.getUnitId()));
                    infoVo.setGreyCode(communityGreyCodeService.selectCountByUintId(infoVo.getUnitId()));
                    infoVo.setYellowCode(communityYellowCodeService.selectCountByUintId(infoVo.getUnitId()));
                    infoVo.setRedCode(communityRedCodeService.selectCountByUintId(infoVo.getUnitId()));
                    infoVoList.add(infoVo);
                }
            });
        }
        return infoVoList;
    }

    /**
     * 查询单元内人口
     *
     * @param unitId 单元id
     * @return int
     * @author kennyouchou
     * @since 2022/10/5 22:55
     **/
    @Override
    public int selectBuildingUserCount(String unitId) {
        return this.baseMapper.selectUnitIdUserCount(unitId);
    }

}
