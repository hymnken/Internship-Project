package com.kennyouchou.mail.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kennyouchou.mail.entity.CommunityMessageEmail;
import com.kennyouchou.mail.mapper.CommunityMessageEmailMapper;
import com.kennyouchou.mail.service.CommunityMessageEmailService;
import com.kennyouchou.mail.vo.UserMessageVo;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 社区邮件信息表 服务实现类
 * </p>
 *
 * @author kennyouchou
 * @since 2022-10-29
 */
@Service
public class CommunityMessageEmailServiceImpl extends ServiceImpl<CommunityMessageEmailMapper, CommunityMessageEmail> implements CommunityMessageEmailService {

    /**
     * 查询用户的邮件信息
     *
     * @param userIds 用户ids
     * @return java.util.List<com.kennyouchou.mail.vo.UserMessageVo>
     * @author kennyouchou
     * @since 2022/10/29 15:29
     **/
    @Override
    public List<UserMessageVo> findByUserIds(List<String> userIds) {
        return this.baseMapper.findByUserIds(userIds);
    }

    @Override
    public void updateEmailIsEnable(String emailId, Integer isEnable) {
        LambdaUpdateWrapper<CommunityMessageEmail> wrapper = new LambdaUpdateWrapper<>();
        wrapper.eq(CommunityMessageEmail::getId, emailId)
                .set(CommunityMessageEmail::getIsEnable, isEnable);
        this.update(wrapper);
    }
}
