/**
 * Date: 2018-03-23 15:32:29.
 * 
 * @author: lizhipeng.
 */
package cn.customs.h2018.sample.service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import cn.customs.h2018.sample.pojo.Entry;
import cn.customs.h2018.sample.pojo.EntryHead;
import cn.customs.h2018.sample.pojo.EntryList;
import lombok.extern.slf4j.Slf4j;

/**
 * Date: 2018-03-23 15:32:29.
 * 
 * @author: lizhipeng.
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class BussinessServiceTests {

  
  @Autowired
  EntryService eService;
  
  @Test
  public void testSava() {

    String id = "31221";

    EntryHead h =
        EntryHead.builder().entryId(id).iePort("0100").declDate(LocalDateTime.now()).build();

    List<EntryList> l = Lists.newArrayList();
    for (int i = 0; i < 5; i++) {
      EntryList temp = EntryList.builder().entryId(id).gNo(Strings.padStart(Integer.toString(i), 3, '0'))
          .codeTs("8100000000").gName("计算机").build();
      l.add(temp);
    }
    
    Entry e = Entry.builder().entryHead(h).entryList(l).build();

    eService.save(e);    
  }

}

