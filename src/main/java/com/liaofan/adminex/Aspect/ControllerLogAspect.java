package com.liaofan.adminex.Aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


/**
 * 切面类
 */
@Aspect
@Component
@Slf4j
public class ControllerLogAspect {
    /**
     * 对所有的接口 添加日志 日志信息有 请求地址 被请求地址 请求参数
     *
     * @param joinPoint
     */
    @Before("@within(org.springframework.stereotype.Controller) || @within(org.springframework.web.bind.annotation.RestController)")  // 对所有的接口 添加日志
    public void restLogAccess(JoinPoint joinPoint) {
        String declaringTypeName = joinPoint.getSignature().getDeclaringTypeName();
        System.out.println(declaringTypeName);
        // 获取请求的request
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        String url = requestAttributes.getRequest().getRequestURI();   // 获取请求的url
        String remoteAddr = requestAttributes.getRequest().getRemoteAddr();    // 获取请求的ip地址
        log.info("[WEB] remoteAddr: {},  URL: {}, args: {}", remoteAddr, url, joinPoint.getArgs());   // 输出日志
    }

}
