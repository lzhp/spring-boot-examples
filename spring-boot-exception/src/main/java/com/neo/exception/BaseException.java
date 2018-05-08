/**
 * Date: 2018-04-30 21:28:53.
 */
package com.neo.exception;

import com.google.common.base.CaseFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Date: 2018-04-30 21:28:53.
 * 
 * @author: lizhipeng.
 * @description:
 */
@Getter
@ToString
public class BaseException extends RuntimeException {

  /**
   * serialVersionUID:.
   */
  private static final long serialVersionUID = 4773191322243855500L;

  /**
   * 错误编号
   */
  private final String code;

  /**
   * 错误编号，英文
   */
  private final String codeEn;

  /**
   * 关键业务单证代码
   */
  private final String bussinessId;
  
  /**
   * 附加错误信息
   */
  @Setter
  private String addtionalMessage;


  /**
   * 业务异常
   * 
   * @param errorEnum 业务异常枚举值
   */
  public <T extends Enum<T> & ErrorEnumInterface> BaseException(T errorEnum) {
    this(errorEnum, "");
  }

  /**
   * 业务异常
   * 
   * @param errorEnum 业务异常枚举值
   * @param bussinessId 关键业务单证编号，如报关单号
   */
  public <T extends Enum<T> & ErrorEnumInterface> BaseException(T errorEnum,
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
  public <T extends Enum<T> & ErrorEnumInterface> BaseException(T errorEnum,
      String bussinessId, Throwable cause) {
    super(errorEnum.getErrorInfo().getMessage(), cause);
    ErrorInfo errorInfo = errorEnum.getErrorInfo();
    this.code = errorInfo.getCode();
    this.bussinessId = bussinessId;
    this.codeEn = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, errorEnum.name());
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
  public BaseException(String message, String errorCode, String codeEn, String bussinessId,
      Throwable cause) {
    super(message, cause);
    this.code = errorCode;
    this.bussinessId = bussinessId;
    this.codeEn = codeEn;
  }
}

