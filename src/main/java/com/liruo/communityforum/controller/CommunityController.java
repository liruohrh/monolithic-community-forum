package com.liruo.communityforum.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.liruo.communityforum.model.domain.Community;
import com.liruo.communityforum.infrasturcture.mvc.BaseResp;
import com.liruo.communityforum.service.CommunityService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:liruo
 * @Date:2023-06-15-21:14:19
 * @Desc
 */
@RequestMapping("/community")
@RestController
public class CommunityController {

  @Resource
  private CommunityService communityService;

  @GetMapping("/list")
  public BaseResp<List<Community>> listByPPresidentId(@RequestParam("presidentId") Long presidentId) {
    return BaseResp.ok(communityService
        .list(new LambdaQueryWrapper<Community>()
        .eq(Community::getPresidentId, presidentId))
    );
  }

}
