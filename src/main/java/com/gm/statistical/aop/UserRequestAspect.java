package com.gm.statistical.aop;

import com.gm.statistical.exception.InvalidUserIdException;
import com.gm.statistical.request.CenterRequest;
import com.gm.statistical.request.ClassRequest;
import com.gm.statistical.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @Description:
 * @Author: zrk
 * @Date: 2019/12/26
 */
@Slf4j
@Component
@Aspect
public class UserRequestAspect {

    @Resource
    private UserService userService;

    @Pointcut("execution(* com.gm.statistical.controller.student..*.*(..)) ")
    private void pointCut() {}

    @Around("pointCut()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        return requestCut(joinPoint);
    }

    private Object requestCut(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String userIdStr = request.getHeader("X-GM-userId");
        String longitude = request.getHeader("X-GM-lng");
        String latitude = request.getHeader("X-GM-lat");
        String platformStr = request.getHeader("X-GM-platform");
        String deviceIdStr = request.getHeader("X-GM-deviceId");
        Long userId = null;
        if(StringUtils.isNotEmpty(userIdStr)){
            userId = Long.valueOf(userIdStr);
        }
        if(args != null){
            for (Object arg : args) {
                if(arg instanceof ClassRequest){
                    ClassRequest classUserRequest = (ClassRequest)arg;
                    if(userId == null || userId == 0){
                        throw new InvalidUserIdException();
                    }
                    userId = userService.getClassUserId(userId);
                    classUserRequest.setUserId(userId);
                    classUserRequest.setLatitude(latitude);
                    classUserRequest.setLongitude(longitude);
                    if(StringUtils.isNotEmpty(platformStr)) {
                        classUserRequest.setPlatform(Integer.valueOf(platformStr));
                    }
                    classUserRequest.setDeviceId(deviceIdStr);
                } else if(arg instanceof CenterRequest){
                    CenterRequest userCenterRequest = (CenterRequest)arg;
                    if(userId == null || userId == 0){
                        throw new InvalidUserIdException();
                    }
                    Integer platform = null;
                    if(StringUtils.isNotEmpty(platformStr)){
                        platform = Integer.valueOf(platformStr);
                    }
                    if(platform != null && platform == 2){
                        //web端登录接口目前直接返回的是ucenter库userId,因此无需转换
                    } else {
                        userId = userService.getUCenterUserId(userId);
                    }
                    userCenterRequest.setUserId(userId);
                }
            }
        }
        Object result = joinPoint.proceed();

        return result;
    }
}
