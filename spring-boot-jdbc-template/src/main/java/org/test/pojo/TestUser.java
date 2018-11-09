package org.test.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestUser {

  private long id;
  // private String userName;
  private String passWord;
  private String userSex;
  private String nickName;

  public TestUser(String userName, String passWord, String userSex, String nickName) {
    super();
    this.passWord = passWord;
    // this.userName = userName;
    this.userSex = userSex;
    this.nickName = nickName;
  }
}
