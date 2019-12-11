package com.gm.statistical.service.impl;

import com.gm.statistical.model.WatchVideoInfoDTO;
import com.gm.statistical.model.web.ResultStatus;
import com.gm.statistical.service.StudyRecordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: zrk
 * @Date: 2019/12/10
 */
@Slf4j
@Service
public class StudyRecordServiceImpl implements StudyRecordService {

    @Override
    public ResultStatus setWatchVideoRecord(WatchVideoInfoDTO watchVideoInfoDTO) {
        //将观看信息放入消息队列
        return null;
    }
}
