/**  
 * Date: 2018-03-21 21:11:23. 
 * @author: lizhipeng.
 */  
package cn.customs.h2018.sample.pojo;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
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
@Entity(name="ENTRY_HEAD")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EntryHead {

  @Id
  @Column(name="ENTRY_HEAD")
  private String entryId;
  
  @Column(name="I_E_PORT")
  private String iePort;
  
  @Column(name="MASTER_CUSTOMS")
  private String masterCustoms;
  
  @Column(name="DECL_DATE")
  private LocalDateTime declDate;
  
  @Column(name="NET_WEIGHT")
  private Double netWeight;
  
  @Column(name="OWNER_NAME")
  private String ownerName;
  
  @Version
  @Column(name="VERSION")
  private Long version;
  
  @Column(name = "CREATE_TIME", updatable=false)
  @CreationTimestamp
  private LocalDateTime createdTime;

  @Column(name = "LAST_UPDATE_TIME")
  @UpdateTimestamp
  private LocalDateTime lastUpdateTime;  
}
  
