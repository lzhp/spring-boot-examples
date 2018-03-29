/**  
 * Date: 2018-03-21 21:41:18. 
 * @author: lizhipeng.
 */  
package cn.customs.h2018.sample.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import cn.customs.h2018.sample.pojo.EntryHead;

/**  
 * Date: 2018-03-21 21:41:18. 
 * @author: lizhipeng.
 * @description: 
 */
@Repository
public interface EntryHeadRepository extends JpaRepository<EntryHead, String> {

}
  
