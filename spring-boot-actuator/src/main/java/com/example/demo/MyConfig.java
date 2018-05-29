/**
 * Date: 2018-05-16 23:28:11.
 */
package com.example.demo;

import java.util.TimeZone;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Date: 2018-05-16 23:28:11.
 * 
 * @author: lizhipeng.
 * @description:
 */
@Component
public class MyConfig {
  @Bean
  public Jackson2ObjectMapperBuilderCustomizer jacksonObjectMapperCustomization() {
    return jacksonObjectMapperBuilder -> jacksonObjectMapperBuilder.timeZone(TimeZone.getDefault());
  }

}

