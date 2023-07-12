package com.liruo.communityforum.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName community_member
 */
@TableName(value ="community_member")
@Data
public class CommunityMember implements Serializable {
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
    private Long communityId;

    /**
     * user_id
     */
    private Long memberId;

    /**
     * max=512, 成员介绍
     */
    private String introduction;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}