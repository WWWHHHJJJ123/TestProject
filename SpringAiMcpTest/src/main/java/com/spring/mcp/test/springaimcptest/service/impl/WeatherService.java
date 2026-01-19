package com.spring.mcp.test.springaimcptest.service.impl;

import com.spring.mcp.test.springaimcptest.service.McpToolService;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

/**
 * @author CiZhong
 * @since 2026/1/7 16:37
 */
@Service
public class WeatherService implements McpToolService {

    private static final List<String> CONDITIONS = List.of(
            "晴", "多云", "阴", "小雨", "中雨", "大雨", "雪"
    );
    private static final List<String> TEMPS = List.of(
            "15°C", "18°C", "22°C", "25°C", "28°C", "30°C", "12°C", "8°C"
    );
    private final Random random = new Random();

    @Tool(description = "查询指定城市的天气，支持中文城市名")
    public String getWeather(String city) {
        String condition = CONDITIONS.get(random.nextInt(CONDITIONS.size()));
        String temperature = TEMPS.get(random.nextInt(TEMPS.size()));
        return String.format("%s的天气：%s，温度：%s", city, condition, temperature);
    }

    @Tool(description = "获取当前日期时间")
    public String getCurrentDateTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    @Tool(description = "设置提醒闹钟，time 为 ISO-8601 格式，例如 2026-01-07T09:00:00")
    public String setAlarm(String time) {
        LocalDateTime alarmTime = LocalDateTime.parse(time, DateTimeFormatter.ISO_DATE_TIME);
        return "闹钟已设置：" + alarmTime;
    }
}