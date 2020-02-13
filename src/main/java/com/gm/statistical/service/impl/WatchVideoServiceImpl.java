package com.gm.statistical.service.impl;

import com.gm.core.base.exception.statistical.InvalidPlatformException;
import com.gm.core.base.utils.StringUtil;
import com.gm.statistical.dao.classdata.CourseLessonLearnDao;
import com.gm.statistical.dao.classdata.StudyLogsDao;
import com.gm.statistical.model.CourseLessonLearnDO;
import com.gm.statistical.model.WatchVideoInfoDTO;
import com.gm.statistical.request.CourseLessonLearnRequest;
import com.gm.statistical.service.WatchVideoService;
import com.gm.statistical.service.converter.WatchVideoInfoConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: zrk
 * @Date: 2019/12/11
 */
@Slf4j
@Service
public class WatchVideoServiceImpl implements WatchVideoService {

    @Resource
    private WatchVideoInfoConverter watchVideoInfoConverter;

    @Resource
    private StudyLogsDao studyLogsDao;

    @Resource
    private CourseLessonLearnDao courseLessonLearnDao;


    @Override
    public void setWatchVideoInfo(WatchVideoInfoDTO watchVideoInfoDTO) {
        validatePlatform(watchVideoInfoDTO.getPlatform());

        //保存观看记录日志
        saveStudyLogs(watchVideoInfoDTO);

        //更新学习记录
        setLearnRecord(watchVideoInfoDTO);
    }

    private void validatePlatform(Integer platform) {
        if(platform == null){
            throw new InvalidPlatformException();
        }
    }

    /**
     * 保存观看记录日志
     * @param watchVideoInfoDTO
     */
    private void saveStudyLogs(WatchVideoInfoDTO watchVideoInfoDTO) {
        studyLogsDao.addStudyLogs(watchVideoInfoConverter.convertDTOToStudyLogsDO(watchVideoInfoDTO));
    }

    /**
     * 设置学习记录
     * @param watchVideoInfoDTO
     */
    private void setLearnRecord(WatchVideoInfoDTO watchVideoInfoDTO) {
        CourseLessonLearnRequest courseLessonLearnRequest = watchVideoInfoConverter.convertDTOToCourseLessonLearnRequest(watchVideoInfoDTO);
        CourseLessonLearnDO courseLessonLearnInfo = courseLessonLearnDao.getLearnInfoByCondition(courseLessonLearnRequest);
        if(courseLessonLearnInfo == null){
            //添加学习记录
            courseLessonLearnDao.addLearnInfo(makeCourseLessonLearn(watchVideoInfoDTO));
        } else {
            //更新学习记录
            setCourseLessonLearnRequest(courseLessonLearnRequest,watchVideoInfoDTO,courseLessonLearnInfo);
            courseLessonLearnDao.updateLearnInfo(courseLessonLearnRequest);
        }
    }

    /**
     * 设置更新学习记录参数
     * @param courseLessonLearnRequest
     * @param watchVideoInfoDTO
     * @param courseLessonLearnInfo
     */
    private void setCourseLessonLearnRequest(CourseLessonLearnRequest courseLessonLearnRequest, WatchVideoInfoDTO watchVideoInfoDTO, CourseLessonLearnDO courseLessonLearnInfo) {
        courseLessonLearnRequest.setStatus("finished".equals(courseLessonLearnInfo.getStatus()) ? "finished" : watchVideoInfoDTO.getStatus());
        long finishedTime = "finished".equals(watchVideoInfoDTO.getStatus()) ? watchVideoInfoDTO.getEndTime() : 0;
        courseLessonLearnRequest.setFinishedTime("finished".equals(courseLessonLearnInfo.getStatus()) ? courseLessonLearnInfo.getFinishedTime() : finishedTime);
        courseLessonLearnRequest.setLearnTime(Math.max(courseLessonLearnInfo.getLearnTime(),watchVideoInfoDTO.getLearnTime()));
        courseLessonLearnRequest.setWatchNum(courseLessonLearnInfo.getWatchNum() + 1);
        courseLessonLearnRequest.setWatchTime(courseLessonLearnInfo.getWatchTime() + Math.max((watchVideoInfoDTO.getEndTime() - watchVideoInfoDTO.getStartTime()),0));
        courseLessonLearnRequest.setUpdateTime(StringUtil.getTimeStamp());
    }

    /**
     * 生成学习记录信息
     * @param watchVideoInfoDTO
     * @return
     */
    private CourseLessonLearnDO makeCourseLessonLearn(WatchVideoInfoDTO watchVideoInfoDTO) {
        return CourseLessonLearnDO.builder()
                .userId(watchVideoInfoDTO.getUserId())
                .courseId(watchVideoInfoDTO.getCourseId())
                .lessonId(watchVideoInfoDTO.getLessonId())
                .status(watchVideoInfoDTO.getStatus())
                .startTime(watchVideoInfoDTO.getStartTime())
                .finishedTime("finished".equals(watchVideoInfoDTO.getStatus()) ? watchVideoInfoDTO.getEndTime() : 0)
                .learnTime(watchVideoInfoDTO.getLearnTime())
                .watchTime(watchVideoInfoDTO.getEndTime() - watchVideoInfoDTO.getStartTime())
                .watchNum(1)
                .videoStatus("playing")
                .updateTime(StringUtil.getTimeStamp())
                .build();
    }
}
