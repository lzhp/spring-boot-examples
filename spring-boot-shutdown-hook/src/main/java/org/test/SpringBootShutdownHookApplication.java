package org.test;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SpringBootShutdownHookApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBootShutdownHookApplication.class, args);
  }

  @PostConstruct
  public void onPostConstruct() {
    log.info("##main onPostConstruct ##");
  }

  @PreDestroy
  public void onExit() {
    log.info("###STOPing##");
    try {
      Thread.sleep(5 * 1000);
    } catch (InterruptedException e) {
      log.error("", e);;
    }
    log.info("###STOP FROM THE LIFECYCLE###");
  }
}
