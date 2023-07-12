package com.liruo.communityforum.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 一个用户对一个帖子的点赞, 因为可能很多, 所以和 comment 分开. 所需的community_id和favor_count去 post 找, 因为需要 content
 * @TableName post_favor
 */
@TableName(value ="post_favor")
@Data
public class PostFavor implements Serializable {
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
    private Long postId;

    /**
     * 
     */
    private Long userId;

    /**
     * post_favor notification 的拥有者
     */
    private Long ownerId;

    /**
     * notification 的read
     */
    private Integer read;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}