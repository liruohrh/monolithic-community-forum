package com.liruo.communityforum.service;

import com.liruo.communityforum.model.domain.PostFavor;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author LYM
* @description 针对表【post_favor(一个用户对一个帖子的点赞, 因为可能很多, 所以和 comment 分开. 所需的community_id和favor_count去 post 找, 因为需要 content)】的数据库操作Service
* @createDate 2023-06-15 20:52:15
*/
public interface PostFavorService extends IService<PostFavor> {

}
