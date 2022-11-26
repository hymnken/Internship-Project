package com.kennyouchou.community.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 期VO
 * </p>
 *
 * @author kennyouchou
 * @since 2022-10-06 16:09:04
 */
@Data
public class PeriodVo implements Serializable {

    @ApiModelProperty("主键")
    private String id;

    @ApiModelProperty("第几期")
    private String periodNumber;

    @ApiModelProperty("排序")
    private Integer sortNo;

    @ApiModelProperty("栋")
    private List<BuildingVo> buildingVoList;
}
