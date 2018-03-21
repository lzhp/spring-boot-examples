package top.h2000.app;

import javax.persistence.Entity;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


/**  
 * Date: 2018-03-18 12:23:54. 
 * @author: lizhipeng.
 * @description：一些描述
 */
@Data
@Entity(name = "COUNTRY")
@EqualsAndHashCode(callSuper=true)
@ToString(callSuper = true)
@NoArgsConstructor
public class Country extends AppSuperClass{

  @Builder
  private Country(String code, String description, Long version) {
    super(code, description, version);
  }
}
  
