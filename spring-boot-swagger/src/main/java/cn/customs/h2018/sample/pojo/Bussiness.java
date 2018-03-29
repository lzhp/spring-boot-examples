/**
 * Date: 2018-03-23 15:05:27.
 * 
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
 * Date: 2018-03-23 15:05:27.
 * 
 * @author: lizhipeng.
 * @description:
 */
@Data
@Entity(name = "Bussiness")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Bussiness {

  @Id
  @Column(name = "ID")
  private String id;



  @Version
  @Column(name = "VERSION")
  private Long version;

  @Column(name = "CREATE_TIME", updatable = false)
  @CreationTimestamp
  private LocalDateTime createdTime;

  @Column(name = "LAST_UPDATE_TIME")
  @UpdateTimestamp
  private LocalDateTime lastUpdateTime;
}

