package com.liruo.communityforum.service;

import com.liruo.communityforum.model.domain.UserFollow;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author LYM
* @description 针对表【user_follow(follower关注followee即追随者关注关注者, 虽然不太顺但是就这样吧, 反正追随者能很好的体现是谁在关注谁)】的数据库操作Service
* @createDate 2023-06-15 20:52:15
*/
public interface UserFollowService extends IService<UserFollow> {

}
