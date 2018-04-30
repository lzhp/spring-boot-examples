/**  
 * Date: 2018-03-21 21:11:23. 
 * @author: lizhipeng.
 */  
package com.neo.pojo;

import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**  
 * Date: 2018-03-21 21:11:23. 
 * @author: lizhipeng.
 * @description: 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EntryHead implements Serializable{
  

  /**  
   * serialVersionUID:.   
   */
  private static final long serialVersionUID = -8993002480641218517L;


  private String entryId;
  

  private String iePort;
  

  private String masterCustoms;
  

  private LocalDateTime declDate;
  

  private Double netWeight;
  

  private Long version;
  

  private LocalDateTime createdTime;


  private LocalDateTime lastUpdateTime;  
}
  
