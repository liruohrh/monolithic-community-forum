package com.liruo.communityforum.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liruo.communityforum.service.NotificationService;
import com.liruo.communityforum.model.domain.Notification;
import com.liruo.communityforum.mapper.NotificationMapper;
import org.springframework.stereotype.Service;

/**
* @author LYM
* @description 针对表【notification】的数据库操作Service实现
* @createDate 2023-06-15 20:52:15
*/
@Service
public class NotificationServiceImpl extends ServiceImpl<NotificationMapper, Notification>
    implements NotificationService {

}




