/**
 * Date: 2018-03-23 15:24:10.
 * 
 * @author: lizhipeng.
 */
package cn.customs.h2018.sample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Date: 2018-03-23 15:24:10.
 * 
 * @author: lizhipeng.
 * @description:
 */
@Configuration
@EnableSwagger2
public class ApplicationConfig {
  
  @Bean
  public Docket produceApi() {
    return new Docket(DocumentationType.SWAGGER_2).select()
        .apis(RequestHandlerSelectors.basePackage("cn.customs.h2018.sample.controller"))
        .paths(PathSelectors.any()).build();
  }
}

