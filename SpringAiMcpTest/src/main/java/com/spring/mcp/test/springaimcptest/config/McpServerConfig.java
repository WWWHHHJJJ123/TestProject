package com.spring.mcp.test.springaimcptest.config;

import com.spring.mcp.test.springaimcptest.service.WeatherService;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author CiZhong
 * @since 2026/1/7 16:31
 */
@Configuration
public class McpServerConfig {
    @Bean
    public ToolCallbackProvider weatherTools(WeatherService weatherService) {
        // 将带有 @Tool 的方法暴露为 MCP 工具
        return MethodToolCallbackProvider.builder()
                .toolObjects(weatherService)
                .build();
    }
}