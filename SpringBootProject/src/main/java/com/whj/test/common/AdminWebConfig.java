package com.whj.test.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @创建人 JieSi
 * @创建时间 2023/6/8
 * @描述
 */
@Configuration
public class AdminWebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**");// /** 表示拦截所有请求,静态资源也会被拦截
//                .excludePathPatterns("/","/login","/css/**","/fonts/**","/images/**","/js/**");//指定放行的请求
    }

}
