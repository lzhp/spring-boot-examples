/**
 * Date: 2018-03-21 21:39:00.
 * 
 * @author: lizhipeng.
 */
package cn.customs.h2018.sample.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import cn.customs.h2018.sample.pojo.EntryList;

/**
 * Date: 2018-03-21 21:39:00.
 * 
 * @author: lizhipeng.
 * @description:
 */
@Repository
public interface EntryListRepository extends JpaRepository<EntryList, EntryList.PkEntryList> {

  List<EntryList> findByEntryId(String entryId);

}

