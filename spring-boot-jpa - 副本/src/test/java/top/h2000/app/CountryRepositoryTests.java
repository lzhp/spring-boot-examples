/**
 * Date: 2018-03-21 14:29:52.
 * 
 * @author: lizhipeng.
 */
package top.h2000.app;

import java.time.LocalDateTime;
import java.util.List;
import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.test.context.junit4.SpringRunner;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

/**
 * Date: 2018-03-21 14:29:52.
 * 
 * @author: lizhipeng.
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CountryRepositoryTests {

  @Autowired
  private CountryRepository repo;

  @Test
  public void testCreateDate() {

    log.info("begin testCreateDate");
    List<Country> myData = getInitData();

    List<String> ids = Lists.newArrayList();
    for (int i = 0; i < myData.size(); i++) {
      ids.add(myData.get(i).getCode());
    }

    List<Country> fromDB1 = Lists.newArrayList(repo.findAllById(ids));
    if (fromDB1.size() > 0) {
      log.info("delete all id: {}", ids);
      repo.deleteAll(fromDB1);
    }

    LocalDateTime now = LocalDateTime.now();
    log.info("now: {}", now);
    List<Country> fromDB = Lists.newArrayList(repo.saveAll(myData));
    log.info(fromDB.toString());

    for (int i = 0; i < fromDB.size(); i++) {
      MatcherAssert.assertThat("i=" + i, fromDB.get(i).getCreatedTime().isAfter(now));
    }
  }


  @Test
  public void testLastUpdateTime() {

    log.info("begin testLastUpdateTime");
    List<Country> myData = getInitData();

    List<String> ids = Lists.newArrayList();
    for (int i = 0; i < myData.size(); i++) {
      ids.add(myData.get(i).getCode());
    }

    log.info("find all");
    List<Country> fromDB1 = Lists.newArrayList(repo.findAllById(ids));
    for (int i = 0; i < fromDB1.size(); i++) {
      for (Country temp : myData) {
        if (temp.getCode().equals(fromDB1.get(i).getCode())) {
          BeanUtils.copyProperties(fromDB1.get(i), temp);
        }
      }
    }

    myData = Lists.newArrayList(repo.saveAll(myData));
    log.info("modify");
    for (Country temp : myData) {
      temp.setDescription(temp.getDescription() + "go");
    }

    LocalDateTime now = LocalDateTime.now();
    log.info("now: {}", now);
    log.info("sava");
    List<Country> fromDB = Lists.newArrayList(repo.saveAll(myData));
    log.info(fromDB.toString());

    for (int i = 0; i < fromDB.size(); i++) {
      MatcherAssert.assertThat("i=" + i, fromDB.get(i).getCreatedTime().isBefore(now));
      MatcherAssert.assertThat("i=" + i, fromDB.get(i).getLastUpdateTime().isAfter(now));
    }
  }

  @Test(expected = ObjectOptimisticLockingFailureException.class)
  public void testJpaVersion() {
    List<Country> list = Lists.newArrayList(repo.findAll());
    if (list.size() > 0) {
      list.get(0).setDescription("eeee");
      list.get(0).setVersion(list.get(0).getVersion() + 1);
      repo.saveAll(list);
    }
  }

  private List<Country> getInitData() {
    List<Country> init = Lists.newArrayList();
    init.add(Country.builder().code("110").description("日本").build());
    init.add(Country.builder().code("142").description("中国").build());
    init.add(Country.builder().code("116").description("香港").build());
    init.add(Country.builder().code("502").description("美国").build());
    return init;
  }
  
  
  @Test
  public void test() {
    Iterable<Country> l = repo.findByDescription("美国");
    log.info(l.toString());
  }

}

