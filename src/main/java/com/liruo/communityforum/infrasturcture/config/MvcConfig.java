package com.liruo.communityforum.infrasturcture.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author:liruo
 * @Date:2023-06-15-22:34:28
 * @Desc
 */
@Configuration
public class MvcConfig {

  @Bean
  public WebMvcConfigurer globalCrossWebMvcConfigurer() {
    return new WebMvcConfigurer() {
      public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("http://localhost:8000")
            .allowedMethods("*")
            .allowedHeaders("*")
            .allowCredentials(true)
            .maxAge(3600);
      }

      @Override
      public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index.html").setViewName("index");
      }
    };
  }
//  @Bean
//  public CorsFilter corsFilter() {
//    CorsConfiguration corsConfiguration = new CorsConfiguration();
//    corsConfiguration.setAllowCredentials(true); //允许接受cookie
//    corsConfiguration.setMaxAge(1000L);
//    corsConfiguration.addAllowedOrigin("*"); // 1允许任何域名使用
//    corsConfiguration.addAllowedHeader("*"); // 2允许任何头
//    corsConfiguration.addAllowedMethod("*"); // 3允许任何方法（post、get等）
//    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//    source.registerCorsConfiguration("/**", corsConfiguration); // 4
//    return new CorsFilter(source);
//  }
}
