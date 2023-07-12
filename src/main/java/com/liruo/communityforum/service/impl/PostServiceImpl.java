package com.liruo.communityforum.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liruo.communityforum.mapper.PostMapper;
import com.liruo.communityforum.service.PostService;
import com.liruo.communityforum.model.domain.Post;
import org.springframework.stereotype.Service;

/**
* @author LYM
* @description 针对表【post】的数据库操作Service实现
* @createDate 2023-06-15 20:52:15
*/
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post>
    implements PostService {

}




