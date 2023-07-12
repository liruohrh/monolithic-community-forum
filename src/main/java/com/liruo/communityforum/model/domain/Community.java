package com.liruo.communityforum.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName community
 */
@TableName(value ="community")
@Data
public class Community implements Serializable {
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
     * max=32
     */
    private String communityType;

    /**
     * 社长
     */
    private Long presidentId;

    /**
     * max=32
     */
    private String name;

    /**
     * max=1024
     */
    private String logoUrl;

    /**
     * max=1024
     */
    private String description;

    /**
     * 人数
     */
    private Integer numbers;

    /**
     * 是否公开
     */
    private Integer close;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}