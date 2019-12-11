package com.gm.statistical.listener;

import com.alibaba.fastjson.JSON;
import com.gm.statistical.bindings.InputWatchVideoBinding;
import com.gm.statistical.model.WatchVideoInfoDTO;
import com.gm.statistical.service.WatchVideoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Description: 监听观看课程视频
 * @Author: zrk
 * @Date: 2019/12/11
 */
@Slf4j
@Component
@EnableBinding(InputWatchVideoBinding.class)
public class WatchVideoListener {

    @Resource
    private WatchVideoService watchVideoService;

    @StreamListener(InputWatchVideoBinding.INPUT)
    public void handle(String value) {
        WatchVideoInfoDTO watchVideoInfoDTO = JSON.parseObject(value, WatchVideoInfoDTO.class);
        watchVideoService.setWatchVideoInfo(watchVideoInfoDTO);
    }

}
