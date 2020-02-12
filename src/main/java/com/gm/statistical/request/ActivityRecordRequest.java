package com.gm.statistical.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @Description:
 * @Author: zrk
 * @Date: 2020/2/12
 */
@Data
public class ActivityRecordRequest extends SchoolRequest{

    /**
     * 活动id
     */
    @ApiModelProperty(value = "活动id",required = true)
    @NotNull(message = "参数错误：活动id不能为空")
    private Long activityId;

    /**
     * 是否为新用户
     */
    @ApiModelProperty(value = "是否为新用户",required = true,allowableValues = "0、1")
    @NotNull(message = "参数错误：是否为新用户不能为空")
    private Integer isNew;

}
