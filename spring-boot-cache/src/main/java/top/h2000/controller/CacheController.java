/**
 * Date: 2018-04-30 12:16:43.
 */
package top.h2000.controller;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import top.h2000.app.CountryController;
import top.h2000.service.CacheService;

/**
 * Date: 2018-04-30 12:16:43.
 * 
 * @author: lizhipeng.
 * @description:
 */
@CrossOrigin(origins = "*", allowCredentials = "true", maxAge = 4800)
@RestController
@Slf4j
@RequestMapping("/my-cache")
public class CacheController {

  @Autowired
  private CacheService cService;
  
  @RequestMapping("/{code}")
  public String testCache(@PathVariable String code) {
    
    String t = cService.getOne2(code);
    
    String t2 = cService.getOne2(code);
    
    log.info("{}",t);
    log.info("{}", t2);
    MatcherAssert.assertThat(t, Matchers.equalTo(t2));
    
    return t + "\n" + t2;
    
  }
  
  

}

