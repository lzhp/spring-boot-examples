/**
 * Date: 2018-03-21 21:41:18.
 * 
 * @author: lizhipeng.
 */
package top.h2000.entry;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

/**
 * Date: 2018-03-21 21:41:18.
 * 
 * @author: lizhipeng.
 * @description:
 */
@Repository
public interface EntryHeadRepository extends JpaRepository<EntryHead, String>,
    JpaSpecificationExecutor<EntryHead>, QueryByExampleExecutor<EntryHead> {

  // 1.以下方法基于属性名称和查询关键字，所以方法名称必须遵循命名规则，并且参数类型要与实体的参数类型一致。
  // 只用于查询方法，以下给出常用的示例

  // 等于
  List<EntryHead> findByOwnerName(String name);

  // And --- 等价于 SQL 中的 and 关键字；
  List<EntryHead> findByOwnerNameAndIePort(String ownerName, String iePort);

  // Or --- 等价于 SQL 中的 or 关键字；
  List<EntryHead> findByOwnerNameOrIePort(String ownerName, String iePort);

  // Between --- 等价于 SQL 中的 between 关键字；
  List<EntryHead> findByNetWeightBetween(Long min, Long max);

  // LessThan --- 等价于 SQL 中的 "<"； 日期类型也可以使用Before关键字
  List<EntryHead> findByNetWeightLessThan(Integer max);

  // LessThanEqual --- 等价于 SQL 中的 "<="；
  List<EntryHead> findByNetWeightLessThanEqual(Integer max);

  // GreaterThan --- 等价于 SQL 中的">"；日期类型也可以使用After关键字
  List<EntryHead> findByNetWeightGreaterThan(Integer min);

  // GreaterThanEqual --- 等价于 SQL 中的">="；
  List<EntryHead> findByNetWeightGreaterThanEqual(Integer min);

  // IsNull --- 等价于 SQL 中的 "is null"；
  List<EntryHead> findByOwnerNameIsNull();

  // IsNotNull --- 等价于 SQL 中的 "is not null"；
  List<EntryHead> findByOwnerNameIsNotNull();

  // Like --- 等价于 SQL 中的 "like"；
  List<EntryHead> findByOwnerNameLike(String name);

  // NotLike --- 等价于 SQL 中的 "not like"；
  List<EntryHead> findByOwnerNameNotLike(String name);

  // OrderBy --- 等价于 SQL 中的 "order by"；
  List<EntryHead> findByOwnerNameNotNullOrderByNetWeightAsc();

  // Not --- 等价于 SQL 中的 "！ ="；
  List<EntryHead> findByMasterCustomsNot(String customsCode);

  // In --- 等价于 SQL 中的 "in"；
  List<EntryHead> findByMasterCustomsIn(Iterable<String> customsCodes);

  // NotIn --- 等价于 SQL 中的 "not in"；
  List<EntryHead> findByMasterCustomsNotIn(Iterable<String> customsCodes);


  // Top --- 查询符合条件的前两条记录，等价与First关键字
  List<EntryHead> findTop2ByMasterCustoms(String customsCode);



  /**
   * between包含两个端点，本函数只含头，不含尾
   *
   * Date: 2018-04-02 11:59:59
   * 
   * @author lizhipeng
   *
   * @param from
   * @param to
   * @return
   */
  @Query(value = "select * from #{#entityName} eh where eh.DECL_DATE>=:from and eh.DECL_DATE<:to",
      nativeQuery = true)
  List<EntryHead> findByDeclDateRange(@Param("from") LocalDateTime from,
      @Param("to") LocalDateTime to);


  List<EntryHead> findByDeclDateGreaterThanEqualAndDeclDateLessThan(LocalDateTime from,
      LocalDateTime to);
}

