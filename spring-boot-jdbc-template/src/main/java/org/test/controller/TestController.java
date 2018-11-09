package org.test.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.test.pojo.TestUser;
import org.test.service.TestService;

@RestController
public class TestController {

  @Autowired
  TestService testService;

  @GetMapping("/users/{id}")
  public TestUser getUser(@PathVariable("id") int id) {
    return testService.findUserById(id);
  }

  @GetMapping("/users2/{id}")
  public TestUser getUser2(@PathVariable("id") int id) {
    return testService.findUserById2(id);
  }

  @GetMapping("/users")
  public List<TestUser> getUsers() {
//    return testService.findUsers();
    return testService.findUserByIds(new int[] {30, 29});
  }
  

}
