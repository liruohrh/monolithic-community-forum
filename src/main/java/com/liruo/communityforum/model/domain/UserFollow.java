package com.liruo.communityforum.model.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * follower关注followee即追随者关注关注者, 虽然不太顺但是就这样吧, 反正追随者能很好的体现是谁在关注谁
 * @TableName user_follow
 */
@TableName(value ="user_follow")
@Data
public class UserFollow implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 关注者
     */
    private Long followee;

    /**
     * 追随者
     */
    private Long follower;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}