package com.gm.statistical.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description:
 * @Author: zrk
 * @Date: 2020/2/12
 */
@ApiModel(value = "学校信息")
@Data
public class SchoolRequest implements Serializable{

    private static final long serialVersionUID = -3381537277424513238L;

    /**
     * 学校名称
     */
    @ApiModelProperty(value = "学校名称")
    private String schoolName;
}
