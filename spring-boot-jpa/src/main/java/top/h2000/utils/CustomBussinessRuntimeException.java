package top.h2000.utils;

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
  private final String errorCode;

  public CustomBussinessRuntimeException(String errorCode, String message) {
    super(message);
    this.errorCode = errorCode;
  }

  public CustomBussinessRuntimeException(String errorCode, Throwable cause) {
    super(cause);
    this.errorCode = errorCode;
  }

  public CustomBussinessRuntimeException(String errorCode, String message, Throwable cause) {
    super(message, cause);
    this.errorCode = errorCode;
  }
}

