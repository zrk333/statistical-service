package com.gm.statistical.service.converter;

import com.gm.statistical.model.ActivityRecordDO;
import com.gm.statistical.model.ActivityRecordDTO;
import com.gm.statistical.request.ActivityRecordRequest;
import com.gm.statistical.request.ClassRequest;

import javax.validation.Valid;

/**
 * @Description:
 * @Author: zrk
 * @Date: 2020/2/12
 */
public interface ActivityRecordConverter {

    /**
     * 请求参数转化为DTO
     * @param request
     * @param userRequest
     */
    ActivityRecordDTO convertRequestToDTO(@Valid ActivityRecordRequest request, ClassRequest userRequest);

    ActivityRecordDO convertDTOToDo(ActivityRecordDTO activityRecordDTO);
}
