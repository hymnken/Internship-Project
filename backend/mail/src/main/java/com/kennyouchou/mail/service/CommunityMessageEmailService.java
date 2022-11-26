package com.kennyouchou.mail.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kennyouchou.mail.entity.CommunityMessageEmail;
import com.kennyouchou.mail.vo.UserMessageVo;

import java.util.List;

/**
 * <p>
 * 社区邮件信息表 服务类
 * </p>
 *
 * @author kennyouchou
 * @since 2022-10-10
 */
public interface CommunityMessageEmailService extends IService<CommunityMessageEmail> {

    /**
     * 查询用户的邮件信息
     * @param userIds 用户ids
     * @return java.util.List<com.kennyouchou.mail.vo.UserMessageVo>
     * @author kennyouchou
     * @since 2022/10/10 15:29
     **/
    List<UserMessageVo> findByUserIds(List<String> userIds);

    void updateEmailIsEnable(String emailId,  Integer isEnable);

}
