package com.gm.statistical.controller;

import com.gm.statistical.model.web.ResultStatus;
import com.gm.statistical.request.WatchVideoRequest;
import com.gm.statistical.service.StudyRecordService;
import com.gm.statistical.service.WatchVideoService;
import com.gm.statistical.service.converter.WatchVideoInfoConverter;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @Description:
 * @Author: zrk
 * @Date: 2019/12/10
 */
@Slf4j
@RestController
@RequestMapping("study")
@Api(value = "学习记录统计", tags = "学习记录统计")
public class StudyRecordController {

    @Resource
    private StudyRecordService studyRecordService;

    @Resource
    private WatchVideoInfoConverter watchVideoInfoConverter;

    @Resource
    private WatchVideoService watchVideoService;

    /**
     * 统计听课记录
     */
    @ApiOperation(value = "统计听课记录", notes = "统计听课记录"
            , tags = {"[学习记录]"}, httpMethod = "POST")
    @PostMapping("setWatchVideoRecord")
    public ResultStatus setWatchVideoRecord(@RequestBody @Valid WatchVideoRequest request) {
        return studyRecordService.setWatchVideoRecordToMq(watchVideoInfoConverter.convertRequestToDTO(request));
    }

    /**
     * 统计听课记录-测试
     */
    @ApiOperation(value = "统计听课记录", notes = "统计听课记录"
            , tags = {"[学习记录]"}, httpMethod = "POST")
    @PostMapping("setWatchVideoRecordTest")
    public ResultStatus setWatchVideoRecordTest(@RequestBody @Valid WatchVideoRequest request) {
        watchVideoService.setWatchVideoInfo(watchVideoInfoConverter.convertRequestToDTO(request));
        return new ResultStatus();
    }
}
