package com.kennyouchou.author.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.PageInfo;
import com.kennyouchou.author.bo.QueryUserListBo;
import com.kennyouchou.author.bo.RegisterBO;
import com.kennyouchou.author.entity.User;
import com.kennyouchou.commons.exception.LException;
import com.kennyouchou.commons.exception.LMailException;
import com.kennyouchou.community.vo.UserHouseholdVo;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author kennyouchou
 * @since 2022-10-23
 */
public interface UserService extends IService<User> {

    /**
     * 根据用户信息查询用户
     * @param user 用户实体
     * @return java.util.List<com.kennyouchou.author.entity.User>
     * @author kennyouchou
     * @since 2022/10/23 16:38
     **/
    List<User> listByUser(User user);

    /**
     * 注册用户
     * @param registerBO 注册用户参数
     * @return java.lang.Integer
     * @author kennyouchou
     * @since 2022/10/23 16:39
     **/
    Integer addUser(RegisterBO registerBO);

    /**
     * 用户修改密码
     * @param oldPassword       旧密码
     * @param newPassword       新密码
     * @param repeatPassword    重复密码
     * @author kennyouchou
     * @since 2022/10/31 11:56
     **/
    void updatePassword(String oldPassword, String newPassword, String repeatPassword);
    
    /**
     * 用户绑定房间号从而绑定角色
     * @param householdId 房间id
     * @author kennyouchou
     * @since 2022/11/8 19:14
     **/
    @Transactional(rollbackFor = Exception.class)
    void bindRoleAndHousehold(String householdId);

    /**
     * 用户搬出房间
     * @param userId 用户id
     * @author kennyouchou
     * @since 2022/11/12 10:02
     **/
    void userMoveOut(String userId);

    /**
     * 审批用户绑定房间信息
     * @param userId            用户id
     * @param examinationStatus 审批状态
     * @author kennyouchou
     * @since 2022/11/13 9:36
     **/
    @Transactional(rollbackFor = Exception.class)
    void updateExamination(String userId, String examinationStatus) throws LMailException;


    /**
     * 查询用户列表
     * @param queryUserBo 查询参数
     * @param pageNum     页码
     * @param pageSize    页大小
     * @return com.github.pagehelper.PageInfo<com.kennyouchou.community.vo.UserHouseholdVo>
     * @author kennyouchou
     * @since 2022/11/13 22:39
     **/
    PageInfo<UserHouseholdVo> findUserList(QueryUserListBo queryUserBo, Integer pageNum, Integer pageSize);

    /**
     * 重置用户密码
     * @param userId 用户id
     * @author kennyouchou
     * @since 2022/11/14 12:27
     **/
    void resetPassword(String userId) throws  LException;

    /**
     * 删除用户
     * @param userId 用户id
     * @author kennyouchou
     * @since 2022/11/14 12:27
     **/
    void deleteUser(String userId) throws LException;

    /**
     * 分页查询用户
     * @param pageNum 页码
     * @param pageSize 页面大小
     * @param name  用户名
     * @return com.github.pagehelper.PageInfo<com.kennyouchou.author.entity.User>
     * @author kennyouchou
     * @since 2022/11/15 18:40
     **/
    PageInfo<User> findAllUser(Integer pageNum, Integer pageSize, String name);

}
