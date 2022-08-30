package com.example.norcomapllication.config;

import com.example.norcomapllication.web.interceptors.StatisticsInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class WebConfiguration implements WebMvcConfigurer {
    private final StatisticsInterceptor statisticsInterceptor;

    public WebConfiguration(StatisticsInterceptor statisticsInterceptor) {
        this.statisticsInterceptor = statisticsInterceptor;
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(statisticsInterceptor);
    }
}
