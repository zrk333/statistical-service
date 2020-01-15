package com.gm.statistical.service.impl;

import com.gm.statistical.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: zrk
 * @Date: 2019/12/26
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Override
    public Long getClassUserId(Long userId) {
        return userId;
    }
}
