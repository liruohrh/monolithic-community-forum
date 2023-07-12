package com.liruo.communityforum.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName comment
 */
@TableName(value ="comment")
@Data
public class Comment implements Serializable {
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
    private Integer deleted;

    /**
     * 
     */
    private Long postId;

    /**
     * 
     */
    private Long userId;

    /**
     * 
     */
    private Long communityId;

    /**
     * 
     */
    private Long parentId;

    /**
     * 
     */
    private Long replyToId;

    /**
     * 
     */
    private Long replyToUserId;

    /**
     * max=1024
     */
    private String content;

    /**
     * 
     */
    private Integer favorCount;

    /**
     * 
     */
    private Integer replyCount;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}