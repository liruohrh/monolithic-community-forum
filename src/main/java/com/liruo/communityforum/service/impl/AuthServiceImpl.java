package com.liruo.communityforum.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.liruo.communityforum.infrasturcture.mvc.exception.AuthException;
import com.liruo.communityforum.infrasturcture.mvc.exception.RequestParameterException;
import com.liruo.communityforum.infrasturcture.util.DigestUtil;
import com.liruo.communityforum.model.domain.User;
import com.liruo.communityforum.model.enumu.LoginType;
import com.liruo.communityforum.model.enumu.VerificationCodeAction;
import com.liruo.communityforum.model.enumu.VerificationCodeType;
import com.liruo.communityforum.model.user.LoginReq;
import com.liruo.communityforum.model.user.RegisterReq;
import com.liruo.communityforum.service.AuthService;
import com.liruo.communityforum.service.UserService;
import com.liruo.communityforum.service.VerificationCodeService;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @Author:liruo
 * @Date:2023-06-15-22:51:56
 * @Desc
 */
@Service
public class AuthServiceImpl implements AuthService {

  @Resource
  private UserService userService;
  @Resource
  private VerificationCodeService verificationCodeService;

  @Override
  public User login(LoginReq loginReq) {
    LoginType match = LoginType.match(loginReq.getLoginType());
    switch (match) {
      case EMAIL:
        return loginByEmail(loginReq);
      case PHONE:
        return loginByMobile(loginReq);
      case USERNAME:
        return loginByUsername(loginReq);
    }
    return null;
  }

  @Override
  public void register(RegisterReq registerReq) {
    VerificationCodeType verificationCodeType = VerificationCodeType.match(
        registerReq.getVerificationType());
    verificationCodeService.verify(
        VerificationCodeAction.REGISTER,
        verificationCodeType,
        registerReq.getUsername(),
        registerReq.getVerificationCode()
    );
    LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<User>()
        .select(User::getUsername, User::getPhone, User::getEmail)
        .eq(User::getUsername, registerReq.getUsername()
        );
    if(StringUtils.isNotEmpty(registerReq.getPhone())){
      queryWrapper.or().eq(User::getPhone, registerReq.getPhone());
    }
    if(StringUtils.isNotEmpty(registerReq.getEmail())){
      queryWrapper.or().eq(User::getEmail, registerReq.getEmail());
    }
    User one = userService.getOne(queryWrapper);
    if(one != null){
      String err="";
      if(StringUtils.isNotEmpty(one.getUsername()) && one.getUsername().equals(registerReq.getUsername())){
        err += "用户名已存在";
      }
      if(StringUtils.isNotEmpty(one.getEmail()) && one.getEmail().equals(registerReq.getEmail())){
        err += ",邮箱已存在";
      }
      if(StringUtils.isNotEmpty(one.getPhone()) && one.getPhone().equals(registerReq.getPhone())){
        err += ",手机号已存在";
      }
      throw new RequestParameterException(err);
    }

    userService.save(new User(registerReq));
  }

  private User loginByUsername(LoginReq loginReq) {
    User user = userService.getByUsername(loginReq.getUsername());
    if (user == null) {
      throw new AuthException("找不到用户/密码错误, " + loginReq);
    }
    if (!user.getPassword().equals(DigestUtil.encode(loginReq.getPassword()))) {
      throw new AuthException("找不到用户/密码错误, " + loginReq);
    }
    return user;
  }

  private User loginByEmail(LoginReq loginReq) {
    String username = loginReq.getUsername();
    verificationCodeService.verify(
        VerificationCodeAction.LOGIN,
        VerificationCodeType.EMAIL,
        username,
        loginReq.getVerificationCode()
    );
    User user = userService.getByEmail(username);
    if (user == null) {
      throw new AuthException("找不到邮箱/密码错误, " + loginReq);
    }
    if (!user.getPassword().equals(DigestUtil.encode(loginReq.getPassword()))) {
      throw new AuthException("找不到邮箱/密码错误, " + loginReq);
    }
    return user;
  }

  private User loginByMobile(LoginReq loginReq) {
    throw new AuthException("unsupport the " + LoginType.PHONE);
  }
}
