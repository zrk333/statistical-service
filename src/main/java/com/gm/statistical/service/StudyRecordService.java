package com.gm.statistical.service;

import com.gm.statistical.model.WatchVideoInfoDTO;
import com.gm.statistical.model.web.ResultStatus;

/**
 * @Description:
 * @Author: zrk
 * @Date: 2019/12/10
 */
public interface StudyRecordService {

    /**
     * 保存观看视频课程记录
     * @param watchVideoInfoDTO
     * @return
     */
    ResultStatus setWatchVideoRecordToMq(WatchVideoInfoDTO watchVideoInfoDTO);
}
