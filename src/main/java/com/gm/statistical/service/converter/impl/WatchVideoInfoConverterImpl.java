package com.gm.statistical.service.converter.impl;

import com.gm.statistical.enums.PlatformEnum;
import com.gm.statistical.model.StudyLogsDO;
import com.gm.statistical.model.WatchVideoInfoDTO;
import com.gm.statistical.request.ClassRequest;
import com.gm.statistical.request.CourseLessonLearnRequest;
import com.gm.statistical.request.WatchVideoRequest;
import com.gm.statistical.service.converter.WatchVideoInfoConverter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

/**
 * @Description:
 * @Author: zrk
 * @Date: 2019/12/10
 */
@Slf4j
@Service
public class WatchVideoInfoConverterImpl implements WatchVideoInfoConverter {

    @Override
    public WatchVideoInfoDTO convertRequestToDTO(@Valid WatchVideoRequest request, ClassRequest baseRequest) {
        WatchVideoInfoDTO watchVideoInfoDTO = new WatchVideoInfoDTO();
        BeanUtils.copyProperties(request,watchVideoInfoDTO);
        if(baseRequest != null){
            watchVideoInfoDTO.setUserId(baseRequest.getUserId());
            watchVideoInfoDTO.setPlatform(baseRequest.getPlatform());
            watchVideoInfoDTO.setMId(baseRequest.getDeviceId());
        }
        log.info("统计听课记录参数：{}", watchVideoInfoDTO.toString());
        return watchVideoInfoDTO;
    }

    @Override
    public StudyLogsDO convertDTOToStudyLogsDO(WatchVideoInfoDTO watchVideoInfoDTO) {
        StudyLogsDO studyLogsDO = new StudyLogsDO();
        BeanUtils.copyProperties(watchVideoInfoDTO,studyLogsDO);
        studyLogsDO.setPlatform(PlatformEnum.getNameById(watchVideoInfoDTO.getPlatform()));
        studyLogsDO.setSchoolName(StringUtils.isEmpty(watchVideoInfoDTO.getSchoolName()) ? "jhwx" : watchVideoInfoDTO.getSchoolName().toLowerCase());
        return studyLogsDO;
    }

    @Override
    public CourseLessonLearnRequest convertDTOToCourseLessonLearnRequest(WatchVideoInfoDTO watchVideoInfoDTO) {
        CourseLessonLearnRequest courseLessonLearnRequest = new CourseLessonLearnRequest();
        BeanUtils.copyProperties(watchVideoInfoDTO,courseLessonLearnRequest);
        return courseLessonLearnRequest;
    }
}
