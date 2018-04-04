/**  
 * Date: 2018-03-21 21:39:00. 
 * @author: lizhipeng.
 */  
package top.h2000.entry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**  
 * Date: 2018-03-21 21:39:00. 
 * @author: lizhipeng.
 * @description: 
 */
@Repository
public interface EntryListRepository extends JpaRepository<EntryList, EntryList.PkEntryList>  {
  
  Iterable<EntryList> findByEntryId(String entryId);

}
  
