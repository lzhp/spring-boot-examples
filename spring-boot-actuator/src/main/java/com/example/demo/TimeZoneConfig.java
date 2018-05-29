/**  
 * Date: 2018-05-18 12:27:47. 
 */  
package com.example.demo;

import java.util.TimeZone;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;

/**  
 * Date: 2018-05-18 12:27:47. 
 * @author: lizhipeng.
 * @description: 
 */
@Component
public class TimeZoneConfig {

  @PostConstruct
  void started() {
      //TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
      TimeZone.setDefault(TimeZone.getDefault());
  }
}
  
