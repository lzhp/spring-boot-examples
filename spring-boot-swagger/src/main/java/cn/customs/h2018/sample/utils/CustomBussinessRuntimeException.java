package cn.customs.h2018.sample.utils;

import lombok.Getter;

/**
 * 自定义的业务逻辑错误
 * Date: 2018-03-21 14:27:35. 
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
   * 业务代码
   */
  private final String BussinessId;

  public CustomBussinessRuntimeException(String errorCode, String bussinessId, String message) {
    super(message);
    this.errorCode = errorCode;
    this.BussinessId = bussinessId;
  }

  public CustomBussinessRuntimeException(String errorCode, String bussinessId, Throwable cause) {
    super(cause);
    this.errorCode = errorCode;
    this.BussinessId = bussinessId;
  }

  public CustomBussinessRuntimeException(String errorCode, String bussinessId, String message,
      Throwable cause) {
    super(message, cause);
    this.errorCode = errorCode;
    this.BussinessId = bussinessId;
  }
}

