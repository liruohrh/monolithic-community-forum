package com.liruo.communityforum.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

/**
 * 
 * @TableName post
 */
@TableName(value ="post")
@Data
public class Post implements Serializable {
    @TableField(exist = false)
    private List<String> tags;
    @TableField(exist = false)
    private User owner;
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
    private Long userId;

    /**
     * 
     */
    private Long communityId;

    /**
     * max=32, 没有则是 casual post
     */
    private String title;

    /**
     * 
     */
    private String content;

    /**
     * 
     */
    private Integer clickCount;

    /**
     * 
     */
    private Integer favorCount;

    /**
     * 
     */
    private Integer commentCount;

    /**
     * 
     */
    private Integer collectedCount;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}