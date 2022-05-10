package com.liaofan.adminex.exception;


import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 自定义异常解析器
 */
@Order(value= Ordered.HIGHEST_PRECEDENCE)     //优先级 数字越小，优先级越高,
                                                                    // 所以这玩意是最小的int
@Component
public class CustomExceptionHandlerResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response,
                                         Object handler,
                                         Exception ex) {
        try {
            response.sendError(500,"发生了异常:" + ex.getMessage());   //返回500错误
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ModelAndView();
    }
}
