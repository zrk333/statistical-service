package com.gm.statistical.service;

import com.gm.statistical.model.WatchVideoInfoDTO;

/**
 * @Description:
 * @Author: zrk
 * @Date: 2019/12/11
 */
public interface WatchVideoService {

    /**
     * 设置观看课程视频记录信息
     * @param watchVideoInfoDTO
     */
    void setWatchVideoInfo(WatchVideoInfoDTO watchVideoInfoDTO);
}
