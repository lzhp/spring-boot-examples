/**  
 * Date: 2018-03-23 18:06:29. 
 * @author: lizhipeng.
 */  
package cn.customs.h2018.sample.pojo;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**  
 * Date: 2018-03-23 18:06:29. 
 * @author: lizhipeng.
 * @description: 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Entry {
  private EntryHead entryHead;
  private List<EntryList> entryList;
}
  
