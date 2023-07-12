package com.liruo.communityforum.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName user_role
 */
@TableName(value ="user_role")
@Data
public class UserRole implements Serializable {
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 
     */
    private Long userId;

    /**
     * 
     */
    private String roleName;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}