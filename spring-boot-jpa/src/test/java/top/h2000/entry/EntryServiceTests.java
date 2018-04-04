/**
 * Date: 2018-03-30 23:05:23.
 * 
 * @author: lizhipeng.
 */
package top.h2000.entry;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

/**
 * Date: 2018-03-30 23:05:23.
 * 
 * @author: lizhipeng.
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class EntryServiceTests {


  @Autowired
  private EntryService eService;

  /**
   * Test method for {@link top.h2000.entry.EntryService#save(top.h2000.entry.Entry)}.
   */
  @Test
  public void testSave() {
    EntryHead head = EntryHead.builder().ownerName("李志鹏").iePort("0100").masterCustoms("0200")
        .declDate(LocalDateTime.now()).netWeight(25.0).build();
    List<EntryList> lists = Lists.newArrayList();
    lists.add(EntryList.builder().codeTs("8200210001").gNo("01").gName("计算机1").build());
    lists.add(EntryList.builder().codeTs("8200210001").gNo("02").gName("计算机2").build());
    lists.add(EntryList.builder().codeTs("8200210001").gNo("03").gName("计算机3").build());

    Entry entry = Entry.builder().entryHead(head).entryList(lists).build();

    log.info("entry to save:{}", entry);

    Entry entryNew = eService.save(entry);

    log.info("entry saved:{}", entryNew);

  }


  @Test(expected = NullPointerException.class)
  public void testSaveError() {
    EntryHead head =
        EntryHead.builder().iePort("0100").masterCustoms("0200").netWeight(25.0).build();

    Entry entry = Entry.builder().entryHead(head).entryList(null).build();

    log.info("entry to save:{}", entry);

    Entry entryNew = eService.save(entry);

    log.info("entry saved:{}", entryNew);

  }


  @Test
  public void testGetEntryHead() {
    List<EntryHead> heads = eService.getEntryHead("0100");
    log.info("size:{}", heads.size());

    heads = eService.getEntryHead("0200");
    log.info("size:{}", heads.size());

    heads = eService.getEntryHead("0201");
    log.info("size:{}", heads.size());
  }

  @Test
  public void testGetEntryHead2() {
    List<EntryHead> heads = eService.getEntryHead("0100");
    log.info("size:{}", heads.size());

    heads = eService.getEntryHead("0200");
    log.info("size:{}", heads.size());

    heads = eService.getEntryHead("0201", Optional.of(LocalDateTime.parse("2018-03-23T13:00:00")));
    log.info("size:{}", heads.size());
  }


  @Test
  public void testGetByDeclDate() {
    List<EntryHead> heads = eService.getByDeclDateRange(LocalDateTime.parse("2018-03-02T13:00:00"),
        LocalDateTime.parse("2018-03-23T23:00:00"));
    log.info("size:{}", heads.size());
  }

  @Test
  public void testGetByOwnerNameLike() {
    List<EntryHead> heads = eService.getByOwnerNameLike("%志%");
    log.info("size:{}", heads.size());
  }
  
  
  @Test
  public void testGetEntryHead3() {
    List<String> masterCustoms = Lists.newArrayList("0100", "0500");
    List<EntryHead> heads = eService.getEntryHead(masterCustoms);
    log.info("size:{}", heads.size());
  }
}

