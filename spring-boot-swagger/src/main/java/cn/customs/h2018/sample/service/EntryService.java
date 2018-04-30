/**
 * Date: 2018-03-23 15:10:33.
 * 
 * @author: lizhipeng.
 */
package cn.customs.h2018.sample.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.customs.h2018.sample.dao.EntryHeadRepository;
import cn.customs.h2018.sample.dao.EntryListRepository;
import cn.customs.h2018.sample.pojo.Entry;
import cn.customs.h2018.sample.pojo.EntryHead;
import cn.customs.h2018.sample.pojo.EntryList;
import lombok.extern.slf4j.Slf4j;


/**
 * Date: 2018-03-23 15:10:33.
 * 
 * @author: lizhipeng.
 * @description:
 */
@Service
@Transactional
@Slf4j
public class EntryService {

  private EntryHeadRepository repoHead;
  private EntryListRepository repoList;

  @Autowired
  EntryService(EntryHeadRepository repoHead, EntryListRepository repoList) {
    this.repoHead = repoHead;
    this.repoList = repoList;
  }


  /**
   * 保存报关单 
   *
   * Date: 2018-03-30 11:20:34 
   * @author lizhipeng 
   *
   * @param entry
   * @return
   */
  public Entry save(cn.customs.h2018.sample.pojo.Entry entry) {

    EntryHead head = entry.getEntryHead();
    List<EntryList> lists = entry.getEntryList();
    
    log.info("old:{}", entry);

    head = repoHead.save(head);
    lists = repoList.saveAll(lists);

    return Entry.builder().entryHead(head).entryList(lists).build();

  }

  public Entry getById(String entryId) {

    EntryHead head = repoHead.findById(entryId).orElse(null);
    List<EntryList> lists = repoList.findByEntryId(entryId);

    return Entry.builder().entryHead(head).entryList(lists).build();

  }
}

