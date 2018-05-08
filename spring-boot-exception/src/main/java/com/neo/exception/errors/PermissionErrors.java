/**
 * Date: 2018-05-01 00:52:36.
 */
package com.neo.exception.errors;

import com.neo.exception.ErrorEnumInterface;
import com.neo.exception.ErrorInfo;
import lombok.Getter;

/**
 * Date: 2018-05-01 00:52:36.
 * 
 * @author: lizhipeng.
 * @description:
 */
public enum PermissionErrors implements ErrorEnumInterface {
  /**
   * 01000, "未登录或登录超时"
   */
  NOT_LOG_IN(new ErrorInfo("01000", "未登录或登录超时")),

  /**
   * 01001, "无权限"
   */
  NO_PERMISSION(new ErrorInfo("01001", "无权限"));
  

  @Getter
  private ErrorInfo errorInfo;

  PermissionErrors(ErrorInfo errorInfo) {
    this.errorInfo = errorInfo;

  }
}

