/**
 * Date: 2018-04-30 21:42:16.
 */
package com.neo.exception.errors;

import com.neo.exception.ErrorEnumInterface;
import com.neo.exception.ErrorInfo;
import lombok.Getter;

/**
 * Date: 2018-04-30 21:42:16.
 * 
 * @author: lizhipeng.
 * @description:
 */
public enum TestErrors implements ErrorEnumInterface {
  /**
   * 10000, "通用异常"
   */
  COMMON_ERROR(new ErrorInfo("10000", "通用异常")),

  /**
   * 10001, "未知异常"
   */
  UNKNOW_ERROR(new ErrorInfo("10001", "未知异常"));

  @Getter
  private ErrorInfo errorInfo;

  TestErrors(ErrorInfo errorInfo) {
    this.errorInfo = errorInfo;
  }
}

