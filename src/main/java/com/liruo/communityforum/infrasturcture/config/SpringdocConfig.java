package com.liruo.communityforum.infrasturcture.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author:liruo
 * @Date:2023-06-15-21:14:31
 * @Desc
 */
@Configuration
public class SpringdocConfig {
  @Bean
  public OpenAPI openAPI() {
    return new OpenAPI()
        .info(new Info()
            .title("OpenAPI-spring-doc-test")
            .version("1.0")
            .description("OpenAPI-spring-doc-test")
            .termsOfService("http://doc.xiaominfo.com")
            .license(new License()
                .name("Apache 2.0")
                .url("http://doc.xiaominfo.com")
            )
        );
  }
}
