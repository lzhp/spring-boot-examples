package org.test.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.test.pojo.TestUser;

@Service
public class TestService {

  @Autowired
  JdbcTemplate jdbcTemplate;

  class UserRowMapper implements RowMapper<TestUser> {
    @Override
    public TestUser mapRow(ResultSet rs, int rowNum) throws SQLException {
      TestUser user = new TestUser();
      user.setId(rs.getInt("id"));
      // user.setUserName(rs.getString("userName"));
      user.setNickName(rs.getString("nick_name"));
      user.setUserSex(rs.getString("user_sex"));
      return user;
    }
  }

  public TestUser findUserById(int id) {
    return jdbcTemplate.queryForObject("select * from users where id=?", new Object[] {id},
        new UserRowMapper());
  }

  public TestUser findUserById2(int id) {
    return jdbcTemplate.queryForObject("select * from users where id=?", new Object[] {id},
        new BeanPropertyRowMapper<TestUser>(TestUser.class));
  }

  public List<TestUser> findUserByIds(int[] ids) {
    String[] s = new String[ids.length];
    Arrays.fill(s, "?");
    String sqlIn = StringUtils.join(s, ',');

    return jdbcTemplate.query("select * from users where id in (" + sqlIn + ")",
        ArrayUtils.toObject(ids), new BeanPropertyRowMapper<>(TestUser.class));
  }


  public List<TestUser> findUsers() {
    return jdbcTemplate.query("select * from users", new BeanPropertyRowMapper<>(TestUser.class));
  }



}
