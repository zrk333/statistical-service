package com.gm.statistical.service.impl;

import com.gm.statistical.dao.gmdata.ActivityRecordDao;
import com.gm.statistical.model.ActivityRecordDO;
import com.gm.statistical.model.ActivityRecordDTO;
import com.gm.statistical.model.web.ResultStatus;
import com.gm.statistical.service.ActivityRecordService;
import com.gm.statistical.service.converter.ActivityRecordConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: zrk
 * @Date: 2020/2/12
 */
@Slf4j
@Service
public class ActivityRecordServiceImpl implements ActivityRecordService {

    @Resource
    private ActivityRecordDao activityRecordDao;

    @Resource
    private ActivityRecordConverter activityRecordConverter;

    @Override
    public ResultStatus setUserRecord(ActivityRecordDTO activityRecordDTO) {
        ActivityRecordDO activityRecordDO = activityRecordConverter.convertDTOToDo(activityRecordDTO);
        Integer count = activityRecordDao.getCountUserRecord(activityRecordDO);
        if(count == null || count < 1){
            activityRecordDao.addUserRecord(activityRecordDO);
        } else {
            return new ResultStatus(ResultStatus.GlobalStatus.ALREADY,"该条记录已存在");
        }
        return new ResultStatus();
    }
}
