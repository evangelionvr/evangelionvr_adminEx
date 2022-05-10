package com.liaofan.adminex.servlet;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * 1. MyServlet -> /my
 * 2. DispatchServlet ->/
 */
@Configuration
public class MyRegisterConfig {

    @Bean
    public ServletRegistrationBean myServlet() {
        MyServlet myServlet = new MyServlet();
        return new ServletRegistrationBean(myServlet,"/my","/my02");
    }

    @Bean
    public FilterRegistrationBean myFilter() {
        MyFiflter myFiflter = new MyFiflter();
//        return new FilterRegistrationBean(myFiflter,myServlet());
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(myFiflter);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/my","/css/*"));
        return new FilterRegistrationBean(myFiflter);
    }

    @Bean
    public ServletListenerRegistrationBean myServletListenerRegistrationBean() {
        MyServletContextListener myServletContextListener = new MyServletContextListener();
        return new ServletListenerRegistrationBean(myServletContextListener);
    }


}
