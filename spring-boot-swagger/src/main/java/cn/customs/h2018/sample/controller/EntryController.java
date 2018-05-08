/**
 * Date: 2018-03-23 14:58:42.
 * 
 * @author: lizhipeng.
 */
package cn.customs.h2018.sample.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.customs.h2018.sample.pojo.Entry;
import cn.customs.h2018.sample.pojo.EntryHead;
import cn.customs.h2018.sample.pojo.EntryList;
import cn.customs.h2018.sample.service.EntryService;
import lombok.extern.slf4j.Slf4j;


/**
 * Date: 2018-03-23 14:58:42.
 * 
 * @author: lizhipeng.
 * @description:
 */
@CrossOrigin(origins = "*", allowCredentials = "true", maxAge = 4800)
@RestController
@Slf4j
@RequestMapping("/entry")
public class EntryController {

  private EntryService eService;

  @Autowired
  public EntryController(EntryService eService) {
    this.eService = eService;

  }

  @GetMapping("/{id}")
  public ResponseEntity<Entry> getEntry(@PathVariable("id") Optional<String> id) {
    String entryId = id.orElse("");

    Entry entry = eService.getById(entryId);
    log.debug(entry.toString());
    return new ResponseEntity<>(entry, HttpStatus.OK);
  }

  @GetMapping("")
  public ResponseEntity<Page<Entry>> getAll() {

    Page<Entry> result = Page.empty();
    return new ResponseEntity<>(result, HttpStatus.OK);
  }

  @GetMapping("/ttt")
  public String getAll2(EntryList b, EntryHead h) {

    return "55555";
  }
  
  @PostMapping("/save")
  public String saveEntry(@RequestBody Entry entry) {
    
    log.debug("{}", entry);
    return "55555";
  }

}

