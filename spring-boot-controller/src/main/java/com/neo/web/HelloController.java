package com.neo.web;

import java.util.UUID;
import javax.servlet.http.HttpSession;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.neo.pojo.Entry;
import com.neo.util.CustomBussinessRuntimeException;
import com.neo.util.ResultBean;
import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class HelloController {

  @GetMapping("/hello")
  public ResultBean<String> hello() {
    return new ResultBean<>("hello world");
  }

  @GetMapping("/uid")
  public String uid(HttpSession session) {
    UUID uid = (UUID) session.getAttribute("uid");
    if (uid == null) {
      uid = UUID.randomUUID();
    }
    session.setAttribute("uid", uid);
    return session.getId();
  }
  
  
  @GetMapping("/testerror")
  public ResultBean<String> testError() {
    if (1==1) {
      throw new CustomBussinessRuntimeException("测试错误", "没有单证", "测试");
    }
      
    return new ResultBean<String>("ok");
  }
  
  @GetMapping("/entry")
  public ResultBean<Page<Entry>> testEntry() {
    if (1==1) {
      throw new CustomBussinessRuntimeException("测试错误", "没有单证", "测试");
    }
      
    return null;
  }  

  @ExceptionHandler({CustomBussinessRuntimeException.class})
  public ResultBean<Entry> handleException(CustomBussinessRuntimeException e) {
    log.error("handleException", e);
    return new ResultBean<>(e);
  }

}
