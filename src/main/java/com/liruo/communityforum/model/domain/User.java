package com.liruo.communityforum.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.liruo.communityforum.model.user.RegisterReq;
import com.liruo.communityforum.model.user.UpdateUserReq;
import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

/**
 * 
 * @TableName user
 */
@TableName(value ="user")
@Data
@NoArgsConstructor
public class User implements Serializable {

    public User(UpdateUserReq updateUserReq) {
        BeanUtils.copyProperties(updateUserReq, this);
    }
    public User(RegisterReq req) {
        BeanUtils.copyProperties(req, this);
    }

    @TableField(exist = false)
    private List<String> roleList;

    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 
     */
    private Long created;

    /**
     * 
     */
    @JsonIgnore
    private Integer deleted;

    /**
     * max=64
     */
    private String email;

    /**
     * max=20, 地区号+手机号, 暂时就支持中国 +86 直接存手机号
     */
    private String phone;

    /**
     * max=16
     */
    private String username;

    /**
     * max=32
     */
    private String nickname;

    /**
     * max=32
     */
    @JsonIgnore
    private String password;

    /**
     * max=1024
     */
    private String avatarUrl;

    /**
     * max=128
     */
    private String personalSignature;

    /**
     * 关注的人数量
     */
    private Integer followeeCount;

    /**
     * 追随者数量
     */
    private Integer followerCount;

    /**
     * 
     */
    private Integer age;

    /**
     * 
     */
    private Integer gender;

    /**
     * max=256
     */
    private String address;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}