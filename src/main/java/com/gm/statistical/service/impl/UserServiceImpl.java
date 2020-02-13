package com.gm.statistical.service.impl;

import com.gm.statistical.dao.classdata.UserDao;
import com.gm.statistical.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: zrk
 * @Date: 2019/12/26
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public Long getClassUserId(Long userId) {
        return userId;
    }

    @Override
    public Long getUCenterUserId(Long userId) {
        if (userId == null || userId == 0) {
            return null;
        }
        return userDao.userId2UcUserId(userId);
    }
}
