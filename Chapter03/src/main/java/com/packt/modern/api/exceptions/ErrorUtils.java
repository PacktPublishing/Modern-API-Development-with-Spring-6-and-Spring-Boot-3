package com.packt.modern.api.exceptions;

/**
 * @author : github.com/sharmasourabh
 * @project : Chapter03 - Modern API Development with Spring and Spring Boot Ed 2
 * @created : 31/10/2022, Monday
 **/
public class ErrorUtils {

  private ErrorUtils() {
  }

  /**
   * Creates and return an error object
   *
   * @param errMsgKey
   * @param errorCode
   * @param httpStatusCode
   * @param url
   * @return error
   */
  public static Error createError(final String errMsgKey, final String errorCode,
      final Integer httpStatusCode) {
    Error error = new Error();
    error.setMessage(errMsgKey);
    error.setErrorCode(errorCode);
    error.setStatus(httpStatusCode);
    return error;
  }
}
