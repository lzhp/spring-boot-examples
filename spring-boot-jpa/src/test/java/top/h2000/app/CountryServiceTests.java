package top.h2000.app;

import java.util.ArrayList;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import top.h2000.app.Country;
import top.h2000.app.CountryService;

/**
 * CountryServiceTests 简短描述. Date: 2018-03-18 20:14:10.
 * 
 * @author: lizhipeng.
 * @description：一些描述
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CountryServiceTests {


  @Autowired
  private CountryService cService;

  @Test
  public void test() {

    ArrayList<Country> init = Lists.newArrayList();
    init.add(Country.builder().code("110").description("日本").version(1L).build());
    init.add(Country.builder().code("142").description("中国").version(1L).build());
    init.add(Country.builder().code("116").description("香港").version(1L).build());
    init.add(Country.builder().code("502").description("美国").version(1L).build());
    
    ArrayList<Country> fromDB = Lists.newArrayList(cService.getAll());
    final ArrayList<Country> tempList = init;
    for (int i =0;i<init.size();i++) {
      final int t =i ;
      Country temp = Iterables.find(init, country-> country.getCode().equals( tempList.get(t).getCode()), null );
      if (temp == null) {
        fromDB.add(init.get(i));
      }
    }
    
    init = Lists.newArrayList(cService.writeData(fromDB));

    init.get(0).setDescription("日本2222");
    cService.writeData(init);

    log.info("first test");
    Iterable<Country> t = cService.getAll();
    MatcherAssert.assertThat(Iterables.size(t), Matchers.greaterThan(3));

    log.info(t.toString());

    Country first = Iterables.get(t, 0);
    MatcherAssert.assertThat(first, Matchers.notNullValue());

    Country another = cService.getOne(first.getCode());
    MatcherAssert.assertThat(first, Matchers.equalTo(another));

    log.info(another.toString());

    Iterable<Country> beginWith11 = cService.getCountryBeginWith("11");
    MatcherAssert.assertThat(Iterables.size(beginWith11), Matchers.equalTo(2));
    Iterable<Country> allBeginWith11 =
        Iterables.filter(beginWith11, country -> country.getCode().startsWith("11"));
    MatcherAssert.assertThat(Iterables.size(beginWith11),
        Matchers.equalTo(Iterables.size(allBeginWith11)));
    log.info(allBeginWith11.toString());

    log.info("first test end");

  }

}

