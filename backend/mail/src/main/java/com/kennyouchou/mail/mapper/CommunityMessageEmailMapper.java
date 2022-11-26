package com.kennyouchou.mail.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kennyouchou.mail.entity.CommunityMessageEmail;
import com.kennyouchou.mail.vo.UserMessageVo;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 社区邮件信息表 Mapper 接口
 * </p>
 *
 * @author kennyouchou
 * @since 2022-10-28
 */
@Mapper
public interface CommunityMessageEmailMapper extends BaseMapper<CommunityMessageEmail> {

    /**
     * 查询用户的邮件信息
     * @param userIds 用户ids
     * @return java.util.List<com.kennyouchou.mail.vo.UserMessageVo>
     * @author kennyouchou
     * @since 2022/10/30 15:29
     **/
    List<UserMessageVo> findByUserIds(@Param("userIds") List<String> userIds);

}
