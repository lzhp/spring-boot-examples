/**
 * Date: 2018-04-30 22:50:45.
 */
package com.neo.domain;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.neo.exception.BaseException;
import com.neo.exception.PermissionException;
import com.neo.exception.errors.TestErrors;
import com.neo.exception.errors.PermissionErrors;
import lombok.extern.slf4j.Slf4j;

/**
 * Date: 2018-04-30 22:50:45.
 * 
 * @author: lizhipeng.
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MyErrorsTests {

  @Test
  public void test() {
    log.info("{}", TestErrors.COMMON_ERROR);

    BaseException t = new BaseException(TestErrors.COMMON_ERROR);
    
    log.error("{}", t.toString());
    log.error("fff", t);
  }
  
  
  @Test
  public void test2() {
    //log.info("{}", TestErrors.COMMON_ERROR);

    PermissionException t = new PermissionException(PermissionErrors.NO_PERMISSION);
    t.setAddtionalMessage("addtional message!");
    
    log.error("{}", t.toString(), t);
    //log.error("fff", t);
  }

}

