package com.gm.statistical.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @Description:
 * @Author: zrk
 * @Date: 2019/12/10
 */
@ApiModel(value = "观看视频信息")
@Data
public class WatchVideoRequest {

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名",required = true)
    @NotEmpty(message = "参数错误：用户名不能为空")
    private String userName;

    /**
     * 课程id
     */
    @ApiModelProperty(value = "课程id",required = true)
    @NotNull(message = "参数错误：课程id不能为空")
    private Long courseId;

    /**
     * 课时id
     */
    @ApiModelProperty(value = "课时id",required = true)
    @NotNull(message = "参数错误：课时id不能为空")
    private Long lessonId;

    /**
     * 学习状态(learning、finished)
     */
    @ApiModelProperty(value = "学习状态",allowableValues = "learning、finished")
    private String status;

    /**
     * 开始时间
     */
    @ApiModelProperty(value = "开始时间",required = true)
    @NotNull(message = "参数错误：开始时间不能为空")
    private Long startTime;

    /**
     * 结束时间
     */
    @ApiModelProperty(value = "结束时间",required = true)
    @NotNull(message = "参数错误：结束时间不能为空")
    private Long endTime;

    /**
     * 学习到课程的位置
     */
    @ApiModelProperty(value = "学习到课程的位置")
    private Long learnTime;

    /**
     * 课时类型(video、live)
     */
    @ApiModelProperty(value = "课时类型",allowableValues = "video、live", required = true)
    @NotEmpty(message = "参数错误：课时类型不能为空")
    private String type;

    /**
     * 学校名称
     */
    @ApiModelProperty(value = "学校名称")
    private String schoolName;

}
