package com.liruo.communityforum.infrasturcture.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import java.util.concurrent.TimeUnit;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfiguration {

  @Bean
  public CacheManager configCacheManager() {
    CaffeineCacheManager manager = new CaffeineCacheManager();
    manager.setCaffeine(Caffeine.newBuilder().expireAfterWrite(4 * 60 * 1000, TimeUnit.MILLISECONDS));
    return manager;
  }

  @Bean
  public Cache verificationCodeCache() {
    return new CaffeineCache(
        "verificationCodeCache",
        Caffeine.newBuilder()
            .expireAfterWrite( 20 * 60 * 1000, TimeUnit.MILLISECONDS)
            .build()
    );
  }

}
