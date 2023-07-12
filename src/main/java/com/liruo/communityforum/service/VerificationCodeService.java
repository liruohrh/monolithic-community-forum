package com.liruo.communityforum.service;

import com.liruo.communityforum.model.dto.VerificationCodeReq;
import com.liruo.communityforum.model.enumu.VerificationCodeAction;
import com.liruo.communityforum.model.enumu.VerificationCodeType;

/**
 * @Author:liruo
 * @Date:2023-06-18-16:01:07
 * @Desc
 */
public interface VerificationCodeService {
  void verify(VerificationCodeAction action, VerificationCodeType type,String target, String verificationCode);

  Boolean sendVerifyCode(VerificationCodeReq req);
}
