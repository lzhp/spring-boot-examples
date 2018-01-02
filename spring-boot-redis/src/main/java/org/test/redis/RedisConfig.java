package org.test.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.test.model.User;

@Configuration
public class RedisConfig {

  /**
   * 这一段加上的话不能自动根据配置文件加载factory，一定要删除.
   */
  // @Bean
  // JedisConnectionFactory jedisConnectionFactory() {
  // JedisConnectionFactory factory = new JedisConnectionFactory();
  // factory.setHostName("192.168.136.131");
  // factory.setPort(6379);
  // return factory;
  // }


  @Bean
  public RedisTemplate<String, User> redisTemplate(RedisConnectionFactory factory) {
    RedisTemplate<String, User> template = new RedisTemplate<String, User>();
    template.setConnectionFactory(factory);
    template.setKeySerializer(new StringRedisSerializer());
    template.setValueSerializer(new JdkSerializationRedisSerializer());
    return template;
  }
}
