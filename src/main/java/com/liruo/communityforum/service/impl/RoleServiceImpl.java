package com.liruo.communityforum.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liruo.communityforum.mapper.RoleMapper;
import com.liruo.communityforum.service.RoleService;
import com.liruo.communityforum.model.domain.Role;
import org.springframework.stereotype.Service;

/**
* @author LYM
* @description 针对表【role】的数据库操作Service实现
* @createDate 2023-06-15 20:52:15
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService {

}




