package com.gm.statistical.service.converter.impl;

import com.gm.statistical.model.WatchVideoInfoDTO;
import com.gm.statistical.request.WatchVideoRequest;
import com.gm.statistical.service.converter.WatchVideoInfoConverter;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

/**
 * @Description:
 * @Author: zrk
 * @Date: 2019/12/10
 */
@Service
public class WatchVideoInfoConverterImpl implements WatchVideoInfoConverter {

    @Override
    public WatchVideoInfoDTO convertRequestToDTO(@Valid WatchVideoRequest request) {
        WatchVideoInfoDTO watchVideoInfoDTO = new WatchVideoInfoDTO();
        BeanUtils.copyProperties(request,watchVideoInfoDTO);
        return watchVideoInfoDTO;
    }
}
