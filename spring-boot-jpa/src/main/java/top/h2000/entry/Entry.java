/**
 * Date: 2018-03-30 15:57:05.
 * 
 * @author: lizhipeng.
 */
package top.h2000.entry;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Date: 2018-03-30 15:57:05.
 * 
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

