/**
 * Date: 2018-03-21 21:41:49.
 * 
 * @author: lizhipeng.
 */
package top.h2000.entry;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.wenhao.jpa.PredicateBuilder;
import com.github.wenhao.jpa.Specifications;
import com.google.common.base.Strings;


/**
 * Date: 2018-03-21 21:41:49.
 * 
 * @author: lizhipeng.
 * @description:
 */
@Service
@Transactional
public class EntryService {

  private EntryListRepository listRepo;
  private EntryHeadRepository headRepo;

  @Autowired
  public EntryService(EntryHeadRepository headRepo, EntryListRepository listRepo) {
    this.headRepo = headRepo;
    this.listRepo = listRepo;
  }

  /**
   * 保存报关单（接口默认）
   *
   * Date: 2018-04-02 08:41:13
   * 
   * @author lizhipeng
   *
   * @param entry
   * @return
   */
  public Entry save(Entry entry) {

    EntryHead head = Objects.requireNonNull(entry.getEntryHead(), "报关单表头不能为空");
    List<EntryList> lists = Objects.requireNonNull(entry.getEntryList(), "报关单表体不能为空");

    // 如果id为空，生成id保存
    if (Strings.isNullOrEmpty(head.getEntryId())) {
      String id = (Math.random() + 1 + "1");
      head.setEntryId(id);
      for (EntryList list : lists) {
        list.setEntryId(id);
      }
    } else {
      // 强制将id设置为与表头一致
      for (EntryList list : lists) {
        list.setEntryId(head.getEntryId());
      }
    }

    head = headRepo.save(head);
    lists = listRepo.saveAll(lists);
    return Entry.builder().entryHead(head).entryList(lists).build();
  }

  /**
   * 根据企业名称（根据接口中函数名自动生成）
   *
   * Date: 2018-04-02 08:51:50
   * 
   * @author lizhipeng
   *
   * @param ownerName
   * @return
   */
  public List<EntryHead> getByOwnerNameLike(String ownerName) {
    return headRepo.findByOwnerNameLike(ownerName);
  }

  /**
   * 根据主管关区取得报关单，关区条件同海关惯例（拼接查询条件）
   *
   * Date: 2018-04-02 08:41:35
   * 
   * @author lizhipeng
   *
   * @param masterCustoms
   * @return
   */
  public List<EntryHead> getEntryHead(String masterCustoms) {

    PredicateBuilder<EntryHead> pb = Specifications.<EntryHead>and();

    masterCustoms = Strings.nullToEmpty(masterCustoms);
    if (masterCustoms == "0000") { // 总署
    } else if (masterCustoms.endsWith("00")) { // 直属关
      pb.like("masterCustoms", masterCustoms.substring(0, 2) + "%");
    } else { // 隶属关
      pb.eq("masterCustoms", masterCustoms);
    }

    return headRepo.findAll(pb.build());
  }


  /**
   * 根据关区号和申报时间范围查找报关单（拼接查询条件）
   *
   * Date: 2018-04-02 08:49:51
   * 
   * @author lizhipeng
   *
   * @param masterCustoms
   * @param declDateFrom
   * @return
   */
  public List<EntryHead> getEntryHead(String masterCustoms, Optional<LocalDateTime> declDateFrom) {

    PredicateBuilder<EntryHead> pb = Specifications.<EntryHead>and();

    masterCustoms = Strings.nullToEmpty(masterCustoms);
    if (masterCustoms == "0000") {

    } else if (masterCustoms.endsWith("00")) {
      pb.like("masterCustoms", masterCustoms.substring(0, 2) + "%");
    } else {
      pb.eq("masterCustoms", masterCustoms);
    }

    if (declDateFrom.isPresent()) {
      pb.ge("declDate", declDateFrom.get());
    }

    return headRepo.findAll(pb.build());
  }

  /**
   * 查询报关单，queryByExample
   *
   * Date: 2018-04-02 09:23:11
   * 
   * @author lizhipeng
   *
   * @param masterCustoms
   * @param iePort
   * @return
   */
  public List<EntryHead> getEntryHead2(String masterCustoms, String iePort) {

    EntryHead e = EntryHead.builder().masterCustoms(masterCustoms).iePort(iePort).build();
    ExampleMatcher matcher =
        ExampleMatcher.matching().withMatcher("masterCustoms", ExampleMatcher.GenericPropertyMatchers.startsWith())
            .withMatcher("iePort", ExampleMatcher.GenericPropertyMatchers.startsWith());

    Example<EntryHead> exmaple = Example.of(e, matcher);

    return headRepo.findAll(exmaple);
  }
  
  /**
   * 根据主管关区号查
   *
   * Date: 2018-04-02 12:36:44 
   * @author lizhipeng 
   *
   * @param masterCustoms
   * @return
   */
  public List<EntryHead> getEntryHead(Iterable<String> masterCustoms) {
    return headRepo.findByMasterCustomsIn(masterCustoms);
  }  


  /**
   * 根据时间范围查找报关单（自定义查询sql）
   *
   * Date: 2018-04-02 08:50:50
   * 
   * @author lizhipeng
   *
   * @param from
   * @param to
   * @return
   */
  public List<EntryHead> getByDeclDateRange(LocalDateTime from, LocalDateTime to) {
    
    //日期范围注意调整一下时间，第一天和最后一天都在范围内
    from = from.toLocalDate().atStartOfDay();
    to = to.toLocalDate().plusDays(1).atStartOfDay();
    
    return headRepo.findByDeclDateRange(from, to);
  }



}

