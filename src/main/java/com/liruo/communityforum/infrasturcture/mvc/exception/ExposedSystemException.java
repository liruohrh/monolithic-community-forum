package com.liruo.communityforum.infrasturcture.mvc.exception;

/**
 * @Author:liruo
 * @Date:2023-06-11-19:50:02
 * @Desc
 */
public class ExposedSystemException extends RuntimeException{
  public ExposedSystemException(String message) {
    super(message);
  }
}
