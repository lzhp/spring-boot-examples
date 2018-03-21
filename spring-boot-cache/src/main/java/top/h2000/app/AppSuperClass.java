package top.h2000.app;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Date: 2018-03-18 12:14:19.
 * 
 * @author: lizhipeng.
 * @description 一些描述
 */
@Data
@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
public class AppSuperClass {

  @Id
  @Column(name="CODE")
  private String code;
  
  @Column(name="DESCRIPTION")
  private String description;
  
  @Version
  @Column(name="VERSION")
  private Long version;

}

