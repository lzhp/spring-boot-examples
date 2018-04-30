/**
 * Date: 2018-04-11 17:23:53.
 */
package com.neo.util;

import com.google.common.base.Throwables;
import lombok.Data;
import lombok.ToString;

/**
 * Date: 2018-04-11 17:23:53.
 * 
 * @author: lizhipeng.
 * @description:
 */
@Data
@ToString(exclude = "detail")
public class ResultBean<T> {

  public static final String SUCCESS = "0";
  public static final String FAIL = "1";

  /**
   * 错误号
   */
  private String code = SUCCESS;

  /**
   * 关键业务单证号码
   */
  private String bussinessId;

  /**
   * 简要错误信息
   */
  private String message = "success";

  /**
   * 详细错误信息(视情况,一般不返回客户端)
   */
  private String detail;

  /**
   * 业务数据
   */
  private T data;

  public ResultBean() {
    super();
  }

  public ResultBean(T data) {
    super();
    this.data = data;
    this.code = SUCCESS;
    this.message = "success";
  }

  public ResultBean(Throwable e) {
    super();
    this.message = e.toString(); // 简单传输
    this.code = FAIL;
    this.detail = Throwables.getStackTraceAsString(e);
  }

  public ResultBean(CustomBussinessRuntimeException e) {
    super();
    this.code = FAIL;
    this.message = e.getMessage();
    this.bussinessId = e.getBussinessId();
    this.detail = Throwables.getStackTraceAsString(e);
  }

}

