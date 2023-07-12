package com.liruo.communityforum.model.user;

import com.liruo.communityforum.infrasturcture.constant.RegexConstant;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

/**
 * @Author:liruo
 * @Date:2023-06-17-17:01:27
 * @Desc
 */
@Data
@Schema(description = "注册请求")
public class RegisterReq {
  @Schema(description = "邮箱/手机号的验证码")
  @Size(max = 7, message = "验证码最多7个字符")
  @NotEmpty(message = "需要邮箱/手机号的验证码")
  private String verificationCode;
  @Schema(description = "验证码的类型")
  @Size(max = 7, message = "验证码最多7个字符")
  @NotEmpty(message = "需要邮箱/手机号的验证码类型")
  private String verificationType;

  /**
   * max=64
   */
  @Email(message = "非法邮箱")
  @Size(max = 64, message = "邮箱最多64个字符")
  private String email;

  /**
   * max=20, 地区号+手机号, 暂时就支持中国 +86 直接存手机号
   */
  @Pattern(regexp = RegexConstant.PHONE_86, message = "非法手机号")
  @Size(max = 20, message = "手机号最多20个字符")
  private String phone;

  /**
   * max=16
   */
  @Size(max = 16, message = "用户名最多16个字符")
  @NotEmpty(message = "用户名为空")
  @Schema(description = "不可重复的标识,比如@")
  private String username;

  /**
   * max=32
   */
  @Size(max = 32, message = "昵称最多32个字符")
  @NotEmpty(message = "昵称为空")
  @Schema(description = "可重复的昵称")
  private String nickname;

  /**
   * max=32
   */
  @Size(max = 32, message = "密码最多32个字符")
  @NotEmpty(message = "密码为空")
  private String password;

  /**
   * max=1024
   */
  @Size(max = 1024, message = "头像url最多1024个字符")
  private String avatarUrl;

  /**
   * max=128
   */
  @Size(max = 256, message = "个性签名最多128个字符")
  private String personalSignature;


  /**
   *
   */
  @Range(min = 0, max = 150, message = "年龄必须在1-150")
  @Schema(description = "0-150")
  private Integer age;

  /**
   *
   */
  @Range(max = 1, message = "非法性别")
  @Schema(description = "0男1女")
  private Integer gender;

  /**
   * max=256
   */
  @Size(max = 256, message = "地址最多256个字符")
  private String address;
}
