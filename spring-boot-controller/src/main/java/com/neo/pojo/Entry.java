/**  
 * Date: 2018-03-23 18:06:29. 
 * @author: lizhipeng.
 */  
package com.neo.pojo;

import java.io.Serializable;
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
public class Entry implements  Serializable {
  /**  
   * serialVersionUID:.   
   */
  private static final long serialVersionUID = 728978655379469540L;
  private EntryHead entryHead;
  private List<EntryList> entryList;
}
  
