package com.kennyouchou.author.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kennyouchou.author.bo.QueryUserListBo;
import com.kennyouchou.author.entity.User;
import com.kennyouchou.community.vo.UserHouseholdVo;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author kennyouchou
 * @since 2022-10-23
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    List<User> listByUser(@Param("user") User user);

    List<UserHouseholdVo> findUserList(QueryUserListBo user);
}
