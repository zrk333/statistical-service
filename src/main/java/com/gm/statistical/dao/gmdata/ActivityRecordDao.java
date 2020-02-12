package com.gm.statistical.dao.gmdata;

import com.gm.statistical.model.ActivityRecordDO;

/**
 * @Description:
 * @Author: zrk
 * @Date: 2020/2/13
 */
public interface ActivityRecordDao {

    /**
     * 保存用户参加活动信息
     * @param activityRecordDO
     */
    void addUserRecord(ActivityRecordDO activityRecordDO);
}
