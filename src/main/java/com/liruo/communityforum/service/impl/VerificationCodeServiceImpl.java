package com.liruo.communityforum.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.liruo.communityforum.infrasturcture.constant.RegexConstant;
import com.liruo.communityforum.infrasturcture.mvc.exception.VerificationCodeException;
import com.liruo.communityforum.mapper.UserMapper;
import com.liruo.communityforum.model.domain.User;
import com.liruo.communityforum.model.dto.VerificationCodeReq;
import com.liruo.communityforum.model.enumu.VerificationCodeAction;
import com.liruo.communityforum.model.enumu.VerificationCodeType;
import com.liruo.communityforum.service.MailService;
import com.liruo.communityforum.service.VerificationCodeService;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.stereotype.Service;

/**
 * @Author:liruo
 * @Date:2023-06-18-16:00:51
 * @Desc
 */
@Service
@Slf4j
public class VerificationCodeServiceImpl implements VerificationCodeService {
  @Resource
  private UserMapper userMapper;
  @Resource
  private MailService mailService;

  @Resource
  private CaffeineCache verificationCodeCache;

  public static String getCacheKey(VerificationCodeType type, String target){
    return type.getValue() + ":" + target;
  }
  @Override
  public void verify(VerificationCodeAction action, VerificationCodeType type,String target, String verificationCode){
    String cacheKey = getCacheKey(type, target);
    String verificationCodeInCache = verificationCodeCache.get(
        cacheKey,
        String.class
    );
    if(StringUtils.isEmpty(verificationCodeInCache)){
      throw new VerificationCodeException(action, type, target, "验证码过期, 请重新获取");
    }
    if(!verificationCodeInCache.equals(verificationCode)){
      throw new VerificationCodeException(action, type, target, "验证失败, 请重新输入");
    }
    verificationCodeCache.evict(cacheKey);
  }

  @Override
  public Boolean sendVerifyCode(VerificationCodeReq req) {
    VerificationCodeAction action = VerificationCodeAction.match(req.getAction());
    VerificationCodeType type = VerificationCodeType.match(req.getType());
    String target = req.getTarget();

    verifyTarget(action, type, target);
    String verificationCode = null;
    switch (type) {
      case EMAIL:
        verificationCode = mailService.generateCode(target, 7);
        break;
      case PHONE:
        throw new VerificationCodeException(action, type, target, "请求验证码失败, 目前不支持手机号");
    }
    verificationCodeCache.put(getCacheKey(type, target), verificationCode);
    return true;
  }

  private void verifyTarget(VerificationCodeAction action, VerificationCodeType type, String target) {
    LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<User>().select(User::getId);
    switch (type) {
      case EMAIL:
        if(!target.matches(RegexConstant.USERNAME)){
          throw new VerificationCodeException(action, type, target, "非法邮箱");
        }
        queryWrapper.eq(User::getEmail, target);
        break;
      case PHONE:
        throw new VerificationCodeException(action, type, target, "请求验证码失败, 目前不支持手机号");
    }
    User one = userMapper.selectOne(queryWrapper);
    switch (action) {
      case LOGIN:
        if(one == null){
          throw new VerificationCodeException(action, type, target, "请求验证码失败");
        }
        break;
      case REGISTER:
        if(one != null){
          throw new VerificationCodeException(action, type, target, target + "已注册,请更换");
        }
        break;
    }
  }
}
