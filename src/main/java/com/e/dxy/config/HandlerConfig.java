package com.e.dxy.config;

import com.e.dxy.interceptor.Handler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class HandlerConfig implements WebMvcConfigurer {

    @Bean
    public Handler handler() {
        return new Handler();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.handler()).addPathPatterns("/user/**");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 添加全局的 CORS 配置
        registry.addMapping("/**") // 匹配所有 URL ，相当于全局配置
                .allowedOriginPatterns("*") // 允许所有请求来源
                .allowCredentials(true) // 允许发送 Cookie
                .allowedMethods("*") // 允许所有请求 Method
                .allowedHeaders("*") // 允许所有请求 Header
                .exposedHeaders("*") // 允许所有响应 Header
                .maxAge(1800L); // 有效期 1800 秒，2 小时
    }
}
