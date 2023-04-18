package com.example.emart24.config;

import com.example.emart24.interceptor.AdminCheckInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new AdminCheckInterceptor())
        .order(1)
        .addPathPatterns("/**") // 모두 못오게 막아
        .excludePathPatterns("/", "/admin/login", "/admin/logout", "/css/**",
            "/favicon.ico", "/products/**", "/carts/**", "/users/**", "/events/**", "/order/**"); // 얘네는 뺴고 (즉, 얘네는 누구든 들어올 수 있게)
  }
}
