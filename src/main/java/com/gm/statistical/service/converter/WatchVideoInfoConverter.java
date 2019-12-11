package com.gm.statistical.service.converter;

import com.gm.statistical.model.StudyLogsDO;
import com.gm.statistical.model.WatchVideoInfoDTO;
import com.gm.statistical.request.CourseLessonLearnRequest;
import com.gm.statistical.request.WatchVideoRequest;

import javax.validation.Valid;

/**
 * @Description:
 * @Author: zrk
 * @Date: 2019/12/10
 */
public interface WatchVideoInfoConverter {

    /**
     * 请求转化为DTO
     * @param request
     * @return
     */
    WatchVideoInfoDTO convertRequestToDTO(@Valid WatchVideoRequest request);

    /**
     * 观看视频信息DTO转化为观看记录DO
     * @param watchVideoInfoDTO
     * @return
     */
    StudyLogsDO convertDTOToStudyLogsDO(WatchVideoInfoDTO watchVideoInfoDTO);

    /**
     * 观看视频信息DTO转化为学习记录DO
     * @param watchVideoInfoDTO
     * @return
     */
    CourseLessonLearnRequest convertDTOToCourseLessonLearnRequest(WatchVideoInfoDTO watchVideoInfoDTO);
}
