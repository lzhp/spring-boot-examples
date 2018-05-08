/**  
 * Date: 2018-05-01 00:43:58. 
 */  
package com.neo.exception;  
 
/**  
 * Date: 2018-05-01 00:43:58. 
 * @author: lizhipeng.
 * @description: 
 */
public class DaoException extends BaseException {

  /**  
   * serialVersionUID:.   
   */
  private static final long serialVersionUID = -1577481289359660252L;

  /**
   * 业务异常
   * 
   * @param errorEnum 业务异常枚举值
   */
  public <T extends Enum<T> & ErrorEnumInterface> DaoException(T errorEnum) {
    this(errorEnum, "");
  }

  /**
   * 业务异常
   * 
   * @param errorEnum 业务异常枚举值
   * @param bussinessId 关键业务单证编号，如报关单号
   */
  public <T extends Enum<T> & ErrorEnumInterface> DaoException(T errorEnum,
      String bussinessId) {
    this(errorEnum, bussinessId, null);
  }

  /**
   * 业务异常
   * 
   * @param errorEnum 业务异常枚举值
   * @param bussinessId 关键业务单证编号，如报关单号
   * @param cause 底层错误
   */
  public <T extends Enum<T> & ErrorEnumInterface> DaoException(T errorEnum,
      String bussinessId, Throwable cause) {
    super(errorEnum, bussinessId, cause);
  }

  /**
   * 自定义业务异常
   * 
   * @param message 错误信息
   * @param errorCode 错误号
   * @param codeEn 错误英文描述
   * @param bussinessId 关键单证编号，如报关单号
   * @param cause 父异常
   */
  public DaoException(String message, String errorCode, String codeEn, String bussinessId,
      Throwable cause) {
    super(message, errorCode, codeEn, bussinessId, cause);
  }
}
  
