package com.whj.com;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI
public class Swagger2Config implements WebMvcConfigurer {


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("doc.html").addResourceLocations(
                "classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**").addResourceLocations(
                "classpath:/META-INF/resources/webjars/");
    }


    @Value("${swagger.enable}")
    Boolean swaggerEnabled;

    @Bean
    public Docket createRestApi() {
        // apis 扫描包范围
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(swaggerEnabled)
                .groupName("本地测试接口")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.zlv11"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * API 说明，包含作者、简介、版本、host、服务URL
     */
    private ApiInfo apiInfo() {
        /**
         *  contact：作者信息
         */
        return new ApiInfoBuilder()
                .title("UDS-BACKEND-TITLE 文档")
                .description("UDS-BACKEND 文档")
                .version("1.0")
                .contact(new Contact("王浩杰", "http://www.XXX.com/", "xxx@qq.com"))
                .build();
    }

}
