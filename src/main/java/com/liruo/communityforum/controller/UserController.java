package com.liruo.communityforum.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.liruo.communityforum.infrasturcture.constant.SessionConstant;
import com.liruo.communityforum.infrasturcture.mvc.BaseResp;
import com.liruo.communityforum.infrasturcture.mvc.exception.AuthException;
import com.liruo.communityforum.model.domain.User;
import com.liruo.communityforum.model.user.UpdateUserReq;
import com.liruo.communityforum.service.UserService;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:liruo
 * @Date:2023-06-15-21:14:19
 * @Desc
 */
@RequestMapping("/user")
@RestController
@Validated
public class UserController {

  @Resource
  private UserService userService;

  @GetMapping("/validate")
  public BaseResp<Boolean> validate(
      @Size(max = 16, message = "用户名最多16个字符")
      @RequestParam("username") String username
  ) {
    return BaseResp.ok(userService.getOne(new LambdaQueryWrapper<User>()
        .select(User::getId)
        .eq(User::getUsername, username)) == null
    );
  }

  @GetMapping("/current")
  public BaseResp<User> getCurrentUser(HttpSession session) {
    Long userId = (Long) session.getAttribute(SessionConstant.LOGIN_USER);
    if (userId == null) {
      throw new AuthException("未登录");
    }
    User user = userService.getByUserId(userId);
    return BaseResp.ok(user);
  }

  /**
   * @param userId 选择userId而不是username是因为username有中文
   * @return
   */
  @GetMapping("/{userId}")
  public BaseResp<User> getUser(
      @Min (value = 1, message = "错误的id")
      @PathVariable("userId") Long userId
  ) {
    return BaseResp.ok(userService.getByUserId(userId));
  }

  @GetMapping("/one")
  public BaseResp<User> getUser(
      @Size(max = 16, message = "用户名最多16个字符")
      @RequestParam("username") String username
  ) {
    return BaseResp.ok(userService.getByUsername(username));
  }

  @PutMapping("/{userId}")
  public BaseResp<Boolean> putUser(
      @Min (value = 1, message = "错误的id") @PathVariable("userId") Long userId,
      @Validated @RequestBody UpdateUserReq updateUserReq) {
    userService.updateUser(userId, updateUserReq);
    return BaseResp.ok(true);
  }

  //  @RolesAllowed("admin")
//  @PostMapping
//  public BaseResp<Boolean> postUser(@RequestBody UserDto userDto) {
//    userService.createUser(userDto);
//    return BaseResp.ok(true);
//  }
//  //  @RolesAllowed("admin")
//  @DeleteMapping("/{userId}")
//  public  BaseResp<Boolean> deleteUser(@PathVariable("userId") Long userId) {
//    userService.removeUser(userId);
//    return BaseResp.ok(true);
//  }
}
