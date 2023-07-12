package com.liruo.communityforum.infrasturcture.mvc.exception;

import com.liruo.communityforum.model.enumu.VerificationCodeAction;
import com.liruo.communityforum.model.enumu.VerificationCodeType;

/**
 * @Author:liruo
 * @Date:2023-06-18-17:33:45
 * @Desc
 */
public class VerificationCodeException extends RuntimeException {

  public VerificationCodeException(VerificationCodeAction action, VerificationCodeType type,
      String target, String message) {
    super(action.getValue() + " need " + " VerificationCode for " + type.getValue() + "=" + target
        + ", err=" + message);
  }
}
