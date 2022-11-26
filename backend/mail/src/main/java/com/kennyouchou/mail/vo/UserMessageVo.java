package com.kennyouchou.mail.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 用户邮件信息vo
 * </p>
 *
 * @author kennyouchou
 * @since 2022-10-28 15:26:45
 */
@Data
public class UserMessageVo implements Serializable {

    @ApiModelProperty("用户id")
    private String userId;

    @ApiModelProperty("用户邮件地址")
    private String email;

    @ApiModelProperty("用户真实姓名")
    private String realName;
}
