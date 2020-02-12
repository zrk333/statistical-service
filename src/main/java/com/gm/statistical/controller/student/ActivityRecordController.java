package com.gm.statistical.controller.student;

import com.gm.statistical.model.web.ResultStatus;
import com.gm.statistical.request.ActivityRecordRequest;
import com.gm.statistical.request.ClassRequest;
import com.gm.statistical.service.ActivityRecordService;
import com.gm.statistical.service.converter.ActivityRecordConverter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @Description:
 * @Author: zrk
 * @Date: 2020/2/12
 */
@RestController
@RequestMapping("activity")
@Api(value = "活动信息统计", tags = "活动信息统计")
public class ActivityRecordController {

    @Resource
    private ActivityRecordService activityRecordService;

    @Resource
    private ActivityRecordConverter activityRecordConverter;

    /**
     * 用户参加活动信息统计
     */
    @ApiOperation(value = "用户参加活动信息统计", notes = "用户参加活动信息统计"
            , tags = {"[记录统计]"}, httpMethod = "POST")
    @PostMapping("setUserRecord")
    public ResultStatus setUserRecord(ClassRequest userRequest, @RequestBody @Valid ActivityRecordRequest request) {
        return activityRecordService.setUserRecord(activityRecordConverter.convertRequestToDTO(request,userRequest));
    }
}
