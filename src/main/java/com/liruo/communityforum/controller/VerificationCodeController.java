package com.liruo.communityforum.controller;

import com.liruo.communityforum.model.dto.VerificationCodeReq;
import com.liruo.communityforum.infrasturcture.mvc.BaseResp;
import com.liruo.communityforum.service.VerificationCodeService;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:liruo
 * @Date:2023-06-17-17:04:29
 * @Desc
 */
@RestController
public class VerificationCodeController {
  @Resource
  private VerificationCodeService verificationCodeService;

  @PostMapping("/verification-code")
  public BaseResp<Boolean> sendVerifyCode(@Validated @RequestBody VerificationCodeReq req) {
    return BaseResp.ok(verificationCodeService.sendVerifyCode(req));
  }
}
