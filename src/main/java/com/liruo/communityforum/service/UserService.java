package com.liruo.communityforum.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liruo.communityforum.model.domain.User;
import com.liruo.communityforum.model.user.UpdateUserReq;

/**
* @author LYM
* @description 针对表【user】的数据库操作Service
* @createDate 2023-06-15 20:52:15
*/
public interface UserService extends IService<User> {
//  void createUser(UserDto userDto);

  void updateUser(Long userId, UpdateUserReq updateUserReq);

//  void removeUser(Long userId);
  User getByUserId(Long userId);

  User getByUsername(String username);

  User getByEmail(String email);
}
