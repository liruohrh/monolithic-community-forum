package com.liruo.communityforum.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName system_notification
 */
@TableName(value ="system_notification")
@Data
public class SystemNotification implements Serializable {
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
     * max=1024
     */
    private String logoUrl;

    /**
     * max=32
     */
    private String themeName;

    /**
     * 
     */
    private String content;

    /**
     * notification 的read
     */
    private Integer read;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}