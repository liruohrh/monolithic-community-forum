package com.liruo.communityforum.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName post_tag
 */
@TableName(value ="post_tag")
@Data
public class PostTag implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 
     */
    private Long postId;

    /**
     * 
     */
    private String tagName;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}