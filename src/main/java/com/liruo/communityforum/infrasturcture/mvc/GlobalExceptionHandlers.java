package com.liruo.communityforum.infrasturcture.mvc;

import com.liruo.communityforum.infrasturcture.mvc.exception.AuthException;
import com.liruo.communityforum.infrasturcture.mvc.exception.ExposedSystemException;
import com.liruo.communityforum.infrasturcture.mvc.exception.RequestParameterException;
import com.liruo.communityforum.infrasturcture.mvc.exception.VerificationCodeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @Author:liruo
 * @Date:2023-06-10-17:07:07
 * @Desc
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandlers {

  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ExceptionHandler({RuntimeException.class, ExposedSystemException.class})
  public BaseResp<String> systemErr(RuntimeException err) {
    Throwable error = err;
    if(err.getCause() != null){
      error = err.getCause();
    }
    if (log.isDebugEnabled()) {
      log.debug("systemErr, ErrorCode={}", ErrorCode.SYSTEM, error);
    }
    if (error instanceof ExposedSystemException) {
      return BaseResp.fail(error.getMessage(), ErrorCode.SYSTEM);
    }
    return BaseResp.fail(ErrorCode.SYSTEM);
  }

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler({RequestParameterException.class})
  public BaseResp<String> requestParameter(RequestParameterException err) {
    Throwable error = err;
    if(err.getCause() != null){
      error = err.getCause();
    }
    if (log.isDebugEnabled()) {
      log.debug("requestParameter, ErrorCode={}", ErrorCode.REQUEST_PARAMETER, error);
    }
    return BaseResp.fail(err.getMessage(), ErrorCode.REQUEST_PARAMETER);
  }
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler({VerificationCodeException.class})
  public BaseResp<String> verificationCodeException(VerificationCodeException err) {
    Throwable error = err;
    if(err.getCause() != null){
      error = err.getCause();
    }
    if (log.isDebugEnabled()) {
      log.debug("verificationCodeException, ErrorCode={}", ErrorCode.REQUEST_PARAMETER, error);
    }
    return BaseResp.fail(err.getMessage(), ErrorCode.REQUEST_PARAMETER);
  }


  @ResponseStatus(HttpStatus.UNAUTHORIZED)
  @ExceptionHandler({AuthException.class})
  public BaseResp<String> authException(AuthException err) {
    Throwable error = err;
    if(err.getCause() != null){
      error = err.getCause();
    }
    if (log.isDebugEnabled()) {
      log.debug("authException, ErrorCode={}", ErrorCode.UNAUTHORIZED, error);
    }
    return BaseResp.fail(err.getMessage(), ErrorCode.UNAUTHORIZED);
  }

}
