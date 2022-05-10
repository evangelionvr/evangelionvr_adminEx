package com.liaofan.adminex.config;

import com.alibaba.druid.support.http.WebStatFilter;
import com.liaofan.adminex.interceptor.LoginInceptor;
import com.liaofan.adminex.interceptor.RedisURLCountInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.Arrays;
import java.util.logging.Filter;

/**
 * 配置拦截器
 * <p>
 * 一定要学会这种方式
 */
//@EnableWebMvc    //全面接管
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {


    //注入拦截器
    private LoginInceptor loginInceptor;

    @Autowired
    RedisURLCountInterceptor redisURLCountInterceptor;


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginInceptor())
//                .addPathPatterns("/**")   //所有请求都会拦截
//                .excludePathPatterns("/", "/login", "/css/**", "/images/**", "/fonts/**", "/js/**","/sql","/mybatis","/getAcct",
//                        "/getCity",
//                        "/insertCity"
//                        );

        //拦截所有请求
        registry.addInterceptor(redisURLCountInterceptor).addPathPatterns("/**").excludePathPatterns("/", "/login", "/css/**", "/images/**", "/fonts/**", "/js/**");

    }

    //注册过滤器
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    //注册自定义的RequestMappingHandlerMapping
    @Bean
    public WebMvcRegistrations webMvcRegistrations() {
        return new WebMvcRegistrations() {
            @Override
            public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
                return WebMvcRegistrations.super.getRequestMappingHandlerMapping();
            }
        };
    }


}
