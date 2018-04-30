/**
 * Date: 2018-03-21 21:11:35.
 * 
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
 * Date: 2018-03-21 21:11:35.
 * 
 * @author: lizhipeng.
 * @description:
 */
@Data

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EntryList implements Serializable {

  private static final long serialVersionUID = -7318488925582179571L;

  private String entryId;
  

  private String gNo;
  

  private String codeTs;
  

  private String gName; 
  

  private Long version;  
  

  private LocalDateTime createdTime;


  private LocalDateTime lastUpdateTime; 


}

