package com.liruo.communityforum.service;

import com.liruo.communityforum.model.domain.User;
import com.liruo.communityforum.model.user.LoginReq;
import com.liruo.communityforum.model.user.RegisterReq;

/**
 * @Author:liruo
 * @Date:2023-06-15-22:51:48
 * @Desc
 */
public interface AuthService {
  User login(LoginReq loginReq);

  void register(RegisterReq registerReq);
}
