package com.gm.statistical.service.converter;

import com.gm.statistical.model.StudyLogsDO;
import com.gm.statistical.model.WatchVideoInfoDTO;
import com.gm.statistical.request.ClassRequest;
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
     * 请求参数转化为DTO
     * @param request
     * @param baseRequest
     * @return
     */
    WatchVideoInfoDTO convertRequestToDTO(@Valid WatchVideoRequest request, ClassRequest baseRequest);

    /**
     * 观看视频信息DTO转化为观看记录DO
     * @param watchVideoInfoDTO
     * @return
     */
    StudyLogsDO convertDTOToStudyLogsDO(WatchVideoInfoDTO watchVideoInfoDTO);

    /**
     * 观看视频信息DTO转化为课时学习请求参数
     * @param watchVideoInfoDTO
     * @return
     */
    CourseLessonLearnRequest convertDTOToCourseLessonLearnRequest(WatchVideoInfoDTO watchVideoInfoDTO);
}
