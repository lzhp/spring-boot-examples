package top.h2000.utils;

import lombok.Getter;

/**
 * CustomBussinessException 简短描述. 
 * Date: 2018-03-20 22:08:20.
 * 
 * @author: lizhipeng.
 * @description：一些描述
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

