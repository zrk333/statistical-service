package com.gm.statistical.service;

import com.gm.statistical.model.ActivityRecordDTO;
import com.gm.statistical.model.web.ResultStatus;

/**
 * @Description:
 * @Author: zrk
 * @Date: 2020/2/12
 */
public interface ActivityRecordService {

    /**
     * 记录用户参加活动信息
     * @param activityRecordDTO
     * @return
     */
    ResultStatus setUserRecord(ActivityRecordDTO activityRecordDTO);
}
