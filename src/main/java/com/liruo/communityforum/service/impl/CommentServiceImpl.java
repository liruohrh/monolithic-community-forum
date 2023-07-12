package com.liruo.communityforum.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liruo.communityforum.service.CommentService;
import com.liruo.communityforum.model.domain.Comment;
import com.liruo.communityforum.mapper.CommentMapper;
import org.springframework.stereotype.Service;

/**
* @author LYM
* @description 针对表【comment】的数据库操作Service实现
* @createDate 2023-06-15 20:52:15
*/
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment>
    implements CommentService {

}




