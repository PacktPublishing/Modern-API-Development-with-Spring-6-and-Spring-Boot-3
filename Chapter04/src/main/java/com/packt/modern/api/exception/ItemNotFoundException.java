package com.packt.modern.api.exception;

import java.io.Serial;

/**
 * @author : github.com/sharmasourabh
 * @project : Chapter04 - Modern API Development with Spring and Spring Boot Ed 2
 **/
public class ItemNotFoundException extends RuntimeException {

  @Serial
  private static final long serialVersionUID = 1L;
  private final String errMsgKey;
  private final String errorCode;

  public ItemNotFoundException(ErrorCode code) {
    super(code.getErrMsgKey());
    this.errMsgKey = code.getErrMsgKey();
    this.errorCode = code.getErrCode();
  }

  public ItemNotFoundException(final String message) {
    super(message);
    this.errMsgKey = ErrorCode.CUSTOMER_NOT_FOUND.getErrMsgKey();
    this.errorCode = ErrorCode.CUSTOMER_NOT_FOUND.getErrCode();
  }

  public String getErrMsgKey() {
    return errMsgKey;
  }

  public String getErrorCode() {
    return errorCode;
  }
}
