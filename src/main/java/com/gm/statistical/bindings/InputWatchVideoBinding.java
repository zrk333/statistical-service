package com.gm.statistical.bindings;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * @Description: 订阅者-观看课程视频
 * @Author: zrk
 * @Date: 2019/12/11
 */
public interface InputWatchVideoBinding {

    /**
     * Topic 名称
     */
    String INPUT = "statistical-watch-video-input";

    /**
     * 监听观看课程视频
     * @return
     */
    @Input(INPUT)
    SubscribableChannel input();
}
