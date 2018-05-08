/**  
 * Date: 2018-04-30 12:26:16. 
 */  
package top.h2000;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import lombok.extern.slf4j.Slf4j;
import top.h2000.service.CacheService;

/**  
 * Date: 2018-04-30 12:26:16. 
 * @author: lizhipeng.
 * @description: 
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CacheServiceTests {

  @Autowired
  private CacheService cService;
  
  @Test
  public void testCache() {
    
    String key = "key";
    String t = cService.getOne2(key);
    
    String t2 = cService.getOne2(key);
    
    log.info("{}",t);
    log.info("{}", t2);
    MatcherAssert.assertThat(t, Matchers.equalTo(t2));
    
    log.info("{}", cService.getOne2("aaa"));
    
  }
}
  
