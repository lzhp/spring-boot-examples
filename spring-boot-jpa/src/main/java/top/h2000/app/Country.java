package top.h2000.app;

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
 * Date: 2018-03-18 12:23:54. 
 * @author: lizhipeng.
 * @description：一些描述
 */
@Data
@Entity(name = "COUNTRY")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Country{
  
  @Id
  @Column(name="CODE")
  private String code;
  
  @Column(name="DESCRIPTION")
  private String description;
  
  @Version
  @Column(name="VERSION")
  private Long version;
  
  //
  @Column(name = "CREATE_TIME", updatable=false)
  @CreationTimestamp
  private LocalDateTime createdTime;

  @Column(name = "LAST_UPDATE_TIME")
  @UpdateTimestamp
  private LocalDateTime lastUpdateTime;  

}
  
