//package com.minlia.apps.sample.rebecca.conf;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//
///**
// * Created by will on 8/26/17.
// */
//public class RedisConfiguration {
//
//  @Bean
//  JedisConnectionFactory jedisConnectionFactory() {
//    return new JedisConnectionFactory();
//  }
//
//  @Bean
//  public RedisTemplate<String, Object> redisTemplate() {
//    RedisTemplate<String, Object> template = new RedisTemplate<String, Object>();
//    template.setConnectionFactory(jedisConnectionFactory());
//    return template;
//  }
//}
