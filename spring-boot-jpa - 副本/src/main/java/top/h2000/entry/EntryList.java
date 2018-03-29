/**
 * Date: 2018-03-21 21:11:35.
 * 
 * @author: lizhipeng.
 */
package top.h2000.entry;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Version;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
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
@Entity(name="ENTRY_LIST")
@IdClass(value = EntryList.PkEntryList.class)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EntryList implements Serializable {

  private static final long serialVersionUID = -7318488925582179571L;
  @Id
  @Column(name="ENTRY_ID")
  private String entryId;
  
  @Id
  @Column(name="G_NO")
  private String gNo;
  
  @Column(name="CODE_TS")
  private String codeTs;
  
  @Column(name="G_NAME")
  private String gName; 
  
  @Version
  @Column(name="VERSION")
  private Long version;  
  
  @Column(name = "CREATE_TIME", updatable=false)
  @CreationTimestamp
  private LocalDateTime createdTime;

  @Column(name = "LAST_UPDATE_TIME")
  @UpdateTimestamp
  private LocalDateTime lastUpdateTime; 

  @Data
  static class PkEntryList implements Serializable {
    private static final long serialVersionUID = -2516243737292351958L;
    private String entryId;
    private String gNo;
  }
}

