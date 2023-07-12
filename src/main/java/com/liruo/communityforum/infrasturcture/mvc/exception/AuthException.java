package com.liruo.communityforum.infrasturcture.mvc.exception;

/**
 * @Author:liruo
 * @Date:2023-06-15-21:33:29
 * @Desc
 */
public class AuthException extends RuntimeException{

  public AuthException(String message) {
    super(message);
  }
}
