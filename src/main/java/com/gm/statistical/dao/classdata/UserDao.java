package com.gm.statistical.dao.classdata;

/**
 * @Description:
 * @Author: zrk
 * @Date: 2019/12/11
 */
public interface UserDao {

    /**
     * 将课程库用户id转为ucenter系统用户id
     * @param userId
     * @return
     */
    Long userId2UcUserId(Long userId);
}
