/**  
 * Date: 2018-04-30 12:19:35. 
 */  
package top.h2000.service;

import java.time.LocalDateTime;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.h2000.app.Country;

/**  
 * Date: 2018-04-30 12:19:35. 
 * @author: lizhipeng.
 * @description: 
 */
@Service
public class CacheService {
  
  private void slowThing() {
    try {
      long time = 3000L;
      Thread.sleep(time);
    } catch (InterruptedException e) {
      throw new IllegalStateException(e);
    }
  }
  
  @Cacheable(cacheNames = "country", key="#code")
  public String getOne2(String code) {
    LocalDateTime t = LocalDateTime.now();
    slowThing();
    return code + "#" + t.toString();

  }  

}
  
