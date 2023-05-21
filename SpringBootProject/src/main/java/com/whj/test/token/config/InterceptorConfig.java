package com.whj.test.token.config;

import com.whj.test.token.interceptors.JWTInterceptors;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @创建人 JieSi
 * @创建时间 2023/5/21
 * @描述
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new JWTInterceptors())
                .addPathPatterns("/user/test")              //其他接口token验证
                .excludePathPatterns("/user/login");        //所有用户都放行
    }
}
