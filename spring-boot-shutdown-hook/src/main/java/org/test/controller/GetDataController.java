package org.test.controller;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class GetDataController {

  @GetMapping("/test")
  public ResponseEntity<String> getData(
      @RequestParam(value = "name", required = false) String name) {
    return new ResponseEntity<>("hello" + Strings.nullToEmpty(name), HttpStatus.OK);
  }

  @PostConstruct
  public void onPostConstruct() {
    log.info("## onPostConstruct ##");
  }


  @PreDestroy
  public void onExit() {
    log.info("###STOPing controller ##");
    try {
      Thread.sleep(5 * 1000);
    } catch (InterruptedException e) {
      log.error("", e);;
    }
    log.info("###STOP FROM THE LIFECYCLE controller###");
  }

}
