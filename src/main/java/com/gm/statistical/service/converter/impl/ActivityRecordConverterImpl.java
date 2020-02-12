package com.gm.statistical.service.converter.impl;

import com.gm.core.base.utils.StringUtil;
import com.gm.statistical.model.ActivityRecordDO;
import com.gm.statistical.model.ActivityRecordDTO;
import com.gm.statistical.request.ActivityRecordRequest;
import com.gm.statistical.request.ClassRequest;
import com.gm.statistical.service.converter.ActivityRecordConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

/**
 * @Description:
 * @Author: zrk
 * @Date: 2020/2/12
 */
@Slf4j
@Service
public class ActivityRecordConverterImpl implements ActivityRecordConverter {

    @Override
    public ActivityRecordDTO convertRequestToDTO(@Valid ActivityRecordRequest request, ClassRequest userRequest) {
        ActivityRecordDTO activityRecordDTO = new ActivityRecordDTO();
        BeanUtils.copyProperties(request,activityRecordDTO);
        if(userRequest != null){
            activityRecordDTO.setUserId(userRequest.getUserId());
        }
        log.info("用户参加活动记录参数：{}", activityRecordDTO.toString());
        return activityRecordDTO;
    }

    @Override
    public ActivityRecordDO convertDTOToDo(ActivityRecordDTO activityRecordDTO) {
        ActivityRecordDO activityRecordDO = new ActivityRecordDO();
        BeanUtils.copyProperties(activityRecordDTO,activityRecordDO);
        activityRecordDO.setCreateTime(StringUtil.getTimeStamp());
        activityRecordDO.setUpdateTime(StringUtil.getTimeStamp());
        return activityRecordDO;
    }
}
