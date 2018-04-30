package com.neo.util;

import lombok.Getter;

/**
 * 自定义的业务逻辑错误 Date: 2018-03-21 14:27:35.
 * 
 * @author: lizhipeng.
 * @description:
 */
@Getter
public class CustomBussinessRuntimeException extends RuntimeException {
  private static final long serialVersionUID = 1007903410962994318L;

  /**
   * 错误编号
   */
  private final String errorCode;

  /**
   * 关键业务单证代码
   */
  private final String bussinessId;

  public CustomBussinessRuntimeException(String message, String errorCode, String bussinessId) {
    super(message);
    this.errorCode = errorCode;
    this.bussinessId = bussinessId;
  }

  public CustomBussinessRuntimeException(String message, String errorCode, String bussinessId,
      Throwable cause) {
    super(message, cause);
    this.errorCode = errorCode;
    this.bussinessId = bussinessId;
  }

  public CustomBussinessRuntimeException(String message, String errorCode) {
    super(message);
    this.errorCode = errorCode;
    this.bussinessId = "";
  }

  public CustomBussinessRuntimeException(String message, String errorCode, Throwable cause) {
    super(message, cause);
    this.errorCode = errorCode;
    this.bussinessId = "";
  }
}

