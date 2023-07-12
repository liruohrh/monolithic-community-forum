package com.liruo.communityforum.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liruo.communityforum.model.domain.User;
import com.liruo.communityforum.model.domain.UserRole;
import com.liruo.communityforum.mapper.UserMapper;
import com.liruo.communityforum.mapper.UserRoleMapper;
import com.liruo.communityforum.model.user.UpdateUserReq;
import com.liruo.communityforum.infrasturcture.mvc.exception.ExposedSystemException;
import com.liruo.communityforum.service.UserService;
import com.liruo.communityforum.infrasturcture.util.DigestUtil;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author LYM
 * @description 针对表【user】的数据库操作Service实现
 * @createDate 2023-06-15 20:52:15
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {

  @Resource
  private UserMapper userMapper;
  @Resource
  private UserRoleMapper userRoleMapper;

//  @Override
//  public void createUser(UserDto userDto) {
//    userDto.setPassword(DigestUtil.encode(userDto.getPassword()));
//    if (!save(new User(userDto))) {
//      throw new ExposedSystemException("db insert fail");
//    }
//  }

  @Override
  public void updateUser(Long userId, UpdateUserReq updateUserReq) {
    if (StringUtils.isNotEmpty(updateUserReq.getPassword())) {
      updateUserReq.setPassword(DigestUtil.encode(updateUserReq.getPassword()));
    }
    User user = new User(updateUserReq);
    user.setId(userId);
    if (!updateById(user)) {
      throw new ExposedSystemException("db update fail");
    }
  }

//
//  @Override
//  public void removeUser(Long userId) {
//    if (!removeById(userId)) {
//      throw new ExposedSystemException("db delete fail");
//    }
//  }

  @Override
  public User getByUserId(Long userId) {
    User user = this.getById(userId);
    return getUser(user);
  }

  private User getUser(User user) {
    if(user ==null){
      return null;
    }
    List<String> roleNames = userRoleMapper.selectList(new LambdaQueryWrapper<UserRole>()
            .select(UserRole::getRoleName)
            .eq(UserRole::getUserId, user.getId())
        )
        .stream()
        .map(UserRole::getRoleName)
        .collect(Collectors.toList());
    user.setRoleList(roleNames);
    return user;
  }

  @Override
  public User getByUsername(String username) {
    User user = this.getOne(new LambdaQueryWrapper<User>()
        .eq(User::getUsername, username)
    );
    return getUser(user);
  }

  @Override
  public User getByEmail(String email) {
    User user = this.getOne(new LambdaQueryWrapper<User>()
        .eq(User::getEmail, email)
    );
    return getUser(user);
  }
}




