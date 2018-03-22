/**  
 * Date: 2018-03-21 21:41:49. 
 * @author: lizhipeng.
 */  
package top.h2000.entry;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.google.common.collect.Maps;

/**  
 * Date: 2018-03-21 21:41:49. 
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
  
  public Map<String, Object> save(Map<String, Object> entry){
    
    EntryHead head = (EntryHead) entry.get("HEAD");
    @SuppressWarnings("unchecked")
    Iterable<EntryList> lists = (Iterable<EntryList>) entry.get("LIST");
    
    head = headRepo.save(head);
    lists = listRepo.saveAll(lists);
    
    Map<String, Object> result = Maps.newHashMap();
    result.put("HEAD", head);
    result.put("LIST", lists);
    
    return result;
    
  }
  
  
  
  

}
  
