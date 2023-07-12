package com.liruo.communityforum.model.user;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

/**
 * 
 * @TableName user
 */
@Data
public class UpdateUserReq implements Serializable {
    /**
     * max=32
     */
    @Size(max = 32, message = "昵称最多32个字符")
    @NotEmpty(message = "昵称为空")
    @Schema(description = "可重复的昵称")
    private String nickname;

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

    private static final long serialVersionUID = 1L;
}