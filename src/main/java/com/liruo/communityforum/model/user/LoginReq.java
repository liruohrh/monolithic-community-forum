package com.liruo.communityforum.model.user;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 * @Author:liruo
 * @Date:2023-06-15-22:47:16
 * @Desc
 */
@Data
@Schema(description = "登录请求")
public class LoginReq {
  @NotEmpty(message = "用户名/邮箱/手机号为空")
  private String username;

  @Size(max = 32, message = "密码最多32个字符")
  private String password;
  @Schema(description = "邮箱/手机号的验证码")
  @Size(max = 7, message = "验证码最多7个字符")
  private String verificationCode;


  private Boolean autoLogin;

  @NotEmpty(message = "登录类型为空")
  private String loginType;
}
