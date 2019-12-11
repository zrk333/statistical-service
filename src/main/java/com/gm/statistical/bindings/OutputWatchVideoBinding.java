package com.gm.statistical.bindings;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * @Description: 发送消息MQ-观看课程视频
 * @Author: zrk
 * @Date: 2019/12/11
 */
public interface OutputWatchVideoBinding {

    /**
     * Topic 名称
     */
    String OUTPUT = "statistical-watch-video-output";

    @Output(OUTPUT)
    MessageChannel output();
}
