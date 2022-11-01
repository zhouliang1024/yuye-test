/*
package com.example.yuye.biz.component.aspect;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


@Aspect
@Component
@Slf4j
public class WebLogAspect {

    @Pointcut("@annotation(com.example.yuye.biz.component.annotation.WebLog)")
    public void webLog(){

    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes attributes =(ServletRequestAttributes)  RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.format("URL  %s",request.getRequestURL().toString())).append("\n");
        stringBuffer.append(String.format("Ip  %s",request.getRemoteAddr())).append("\n");
        stringBuffer.append(String.format("request args  %s",JSONUtil.toJsonStr(joinPoint.getArgs()))).append("\n");
        log.info(stringBuffer.toString());
    }

    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object result = proceedingJoinPoint.proceed();
        stopWatch.stop();
        log.info("response args：{} cost:{}", JSONUtil.toJsonStr(result),stopWatch.getTotalTimeSeconds());
        return result;
    }
}
*/
