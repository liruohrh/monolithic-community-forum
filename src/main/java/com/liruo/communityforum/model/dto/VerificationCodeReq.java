package com.liruo.communityforum.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author:liruo
 * @Date:2023-06-17-23:17:30
 * @Desc
 */
@Data
@Schema(description = "验证码请求")
@NoArgsConstructor
public class VerificationCodeReq {
  @Schema(description = "请求验证码目的,验证时可以不用")
  @NotEmpty(message = "请求验证码目的为空")
  private String action;
  @Schema(description = "验证码类型")
  @NotEmpty(message = "验证码类型为空")
  private String type;
  @Schema(description = "验证码类型的标识")
  @NotEmpty(message = "验证码类型的标识为空")
  private String target;
}
