package com.kennyouchou.community.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

import com.kennyouchou.commons.pojo.ShiroUser;

/**
 * <p>
 * 用户房间信息
 * </p>
 *
 * @author kennyouchou
 * @since 2022-10-25 21:38:17
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UserHouseholdVo extends AddressVo implements Serializable {

    @ApiModelProperty("用户信息")
    private ShiroUser user;

    @ApiModelProperty("人员类型")
    private String roleTypeName;

}
