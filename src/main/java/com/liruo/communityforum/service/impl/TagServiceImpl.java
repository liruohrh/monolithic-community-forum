package com.liruo.communityforum.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liruo.communityforum.mapper.TagMapper;
import com.liruo.communityforum.service.TagService;
import com.liruo.communityforum.model.domain.Tag;
import org.springframework.stereotype.Service;

/**
* @author LYM
* @description 针对表【tag】的数据库操作Service实现
* @createDate 2023-06-15 20:52:15
*/
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag>
    implements TagService {

}




