package com.kennyouchou.mail.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kennyouchou.mail.entity.CommunityMessage;
import com.kennyouchou.mail.vo.MessageVo;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 社区消息 Mapper 接口
 * </p>
 *
 * @author kennyouchou
 * @since 2022-10-30
 */
@Mapper
public interface CommunityMessageMapper extends BaseMapper<CommunityMessage> {

    List<MessageVo> findListMessageVo(@Param("userId") String userId, @Param("isEmail") Integer isEmail, @Param("isEnable") Integer isEnable, @Param("title") String title);

}
