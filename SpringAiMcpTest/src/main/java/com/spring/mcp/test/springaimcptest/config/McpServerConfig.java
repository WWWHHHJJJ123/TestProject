package com.spring.mcp.test.springaimcptest.config;

import com.spring.mcp.test.springaimcptest.service.McpToolService;
import com.spring.mcp.test.springaimcptest.service.impl.WeatherService;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author CiZhong
 * @since 2026/1/7 16:31
 */
@Configuration
public class McpServerConfig {
    @Bean
    public ToolCallbackProvider weatherTools(List<McpToolService> toolServices) {
        return MethodToolCallbackProvider.builder()
                .toolObjects(toolServices.toArray()) // 将集合转为数组
                .build();
    }
}