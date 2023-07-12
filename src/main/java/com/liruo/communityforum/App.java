package com.liruo.communityforum;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @Author:liruo
 * @Date:2023-06-15-20:57:47
 * @Desc
 */
@EnableCaching
@MapperScan("com.liruo.communityforum.mapper")
@SpringBootApplication
public class App {

  public static void main(String[] args) {
    new SpringApplication(App.class).run(args);
  }
}
