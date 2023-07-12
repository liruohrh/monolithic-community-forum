package com.liruo.communityforum.controller;

import com.liruo.communityforum.infrasturcture.constant.SessionConstant;
import com.liruo.communityforum.infrasturcture.mvc.BaseResp;
import com.liruo.communityforum.infrasturcture.mvc.exception.AuthException;
import com.liruo.communityforum.model.domain.User;
import com.liruo.communityforum.model.user.LoginReq;
import com.liruo.communityforum.model.user.RegisterReq;
import com.liruo.communityforum.service.AuthService;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:liruo
 * @Date:2023-06-15-21:14:19
 * @Desc
 */
@RequestMapping("/auth")
@RestController
public class AuthController {
  @Resource
  private AuthService authService;

  @PostMapping("/login")
  public BaseResp<User> login(@Validated @RequestBody LoginReq loginReq, HttpSession session) {
    if(session.getAttribute(SessionConstant.LOGIN_USER) != null){
      throw new AuthException("不能重复登录");
    }
    User user = authService.login(loginReq);
//    Cookie cookie = new Cookie("CORS-COOKIE", "cookieValue");
//    resp.addCookie(cookie);
    session.setAttribute(SessionConstant.LOGIN_USER, user.getId());
    return BaseResp.ok(user);
  }
  @PostMapping("/logout")
  public BaseResp<Boolean> logout(HttpSession session) {
    if(session.getAttribute(SessionConstant.LOGIN_USER) == null){
      throw new AuthException("未登录");
    }
    session.setAttribute(SessionConstant.LOGIN_USER, null);
    return BaseResp.ok(true);
  }
  @PostMapping("/register")
  public BaseResp<Boolean> register(@Validated @RequestBody RegisterReq registerReq) {
    authService.register(registerReq);
    return BaseResp.ok(true);
  }
}
