package com.gm.statistical.service.impl;

import com.gm.statistical.bindings.OutputWatchVideoBinding;
import com.gm.statistical.model.WatchVideoInfoDTO;
import com.gm.statistical.model.web.ResultStatus;
import com.gm.statistical.service.StudyRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: zrk
 * @Date: 2019/12/10
 */
@Slf4j
@Service
@EnableBinding(OutputWatchVideoBinding.class)
public class StudyRecordServiceImpl implements StudyRecordService {

    @Resource
    private OutputWatchVideoBinding outputWatchVideoBinding;

    @Override
    public ResultStatus setWatchVideoRecordToMq(WatchVideoInfoDTO watchVideoInfoDTO) {
        //将观看信息放入消息队列
        outputWatchVideoBinding.output().send(MessageBuilder.withPayload(watchVideoInfoDTO).setHeader("x-delay", 5000).build());
//        outputWatchVideoBinding.output().send(MessageBuilder.withPayload(watchVideoInfoDTO).build());
        return new ResultStatus();
    }
}
