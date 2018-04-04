/**  
 * Date: 2018-04-02 11:18:54. 
 * @author: lizhipeng.
 */  
package top.h2000;

import java.lang.invoke.MethodHandles;
import java.time.LocalDateTime;
import java.time.LocalTime;
import org.junit.Test;
import lombok.extern.slf4j.Slf4j;

/**  
 * Date: 2018-04-02 11:18:54. 
 * @author: lizhipeng.
 * @description: 
 */
@Slf4j
public class Tests {

  @Test
  public void test() {
    LocalDateTime t = LocalDateTime.now();
    
    log.info("{}",MethodHandles.lookup().lookupClass());
    
    log.info("{}",t);
    
    log.info("{}", t.toLocalDate());
    
    log.info("{}", t.toLocalDate().plusDays(1L).atStartOfDay());
    
    LocalTime midnight = LocalTime.MIDNIGHT;
    
    log.info("{}",midnight);
    
  }

}
  
