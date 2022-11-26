package com.kennyouchou.author.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户角色关联表
 * </p>
 *
 * @author kennyouchou
 * @since 2022-10-23
 */
@Getter
@Setter
@TableName("l_user_role")
@ApiModel(value = "UserRole对象", description = "用户角色关联表")
public class UserRole implements Serializable {

    @ApiModelProperty("主键")
    @TableId(value = "ID", type = IdType.ASSIGN_UUID)
    private String id;

    @ApiModelProperty("用户主键")
    @TableField("USER_ID")
    private String userId;

    @ApiModelProperty("角色主键")
    @TableField("ROLE_ID")
    private String roleId;

    @ApiModelProperty("是否有效（0：无效，1：有效）")
    @TableField("IS_ENABLE")
    private Integer isEnable;

    @ApiModelProperty("创建用户")
    @TableField("CREATE_USER")
    private String createUser;

    @ApiModelProperty("创建时间")
    @TableField("CREATE_TIME")
    private LocalDateTime createTime;

    @ApiModelProperty("修改者")
    @TableField("UPDATE_USER")
    private String updateUser;

    @ApiModelProperty("修改时间")
    @TableField("UPDATE_TIME")
    private LocalDateTime updateTime;

    @ApiModelProperty("是否删除（0：未删除，1：删除）")
    @TableField("IS_DELETE")
    @TableLogic
    private Integer isDelete;

    @ApiModelProperty("删除者")
    @TableField("DELETE_USER")
    private String deleteUser;

    @ApiModelProperty("删除时间")
    @TableField("DELETE_TIME")
    private LocalDateTime deleteTime;


}
