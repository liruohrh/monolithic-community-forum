package com.liruo.communityforum.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.liruo.communityforum.model.domain.Post;
import com.liruo.communityforum.model.domain.PostTag;
import com.liruo.communityforum.model.domain.User;
import com.liruo.communityforum.model.dto.PageDto;
import com.liruo.communityforum.infrasturcture.mvc.BaseResp;
import com.liruo.communityforum.service.PostService;
import com.liruo.communityforum.service.PostTagService;
import com.liruo.communityforum.service.UserService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:liruo
 * @Date:2023-06-15-21:14:19
 * @Desc
 */
@RequestMapping("/post")
@RestController
public class PostController {

  @Resource
  private PostService postService;
  @Resource
  private PostTagService postTagService;
  @Resource
  private UserService userService;

  @GetMapping("/list")
  public BaseResp<PageDto<Post>> list(@RequestParam("communityId") Long communityId,
      @RequestParam("currentPage") Integer currentPage,
      @RequestParam("size") Integer size) {
    Page<Post> page = postService.page(
        new Page<Post>(currentPage, size),
        new LambdaQueryWrapper<Post>()
            .eq(Post::getCommunityId, communityId)
            .orderBy(true, false, Post::getCreated)
    );
    if(page.getRecords().isEmpty()){
      return BaseResp.ok(new PageDto<>(page));
    }
    HashMap<Long, Post> postMap = new HashMap<>();
    List<Long> userIds = new ArrayList<>(page.getRecords().size());
    for (Post record : page.getRecords()) {
      postMap.put(record.getId(), record);
    }

    List<User> users = userService.list(new LambdaQueryWrapper<User>()
        .in(User::getId, userIds));
    HashMap<Long, User> userMap = new HashMap<>();
    for (User user : users) {
      userMap.put(user.getId(), user);
    }

    List<PostTag> postTags = postTagService.list(new LambdaQueryWrapper<PostTag>()
        .select(PostTag::getPostId, PostTag::getTagName)
        .in(PostTag::getPostId, postMap.keySet())
    );

    postTags.forEach(postTag -> {
      Post post = postMap.get(postTag.getId());
      if (CollectionUtils.isEmpty(post.getTags())) {
        post.setOwner(userMap.get(post.getUserId()));
        post.setTags(new ArrayList<>(5));
      }
      post.getTags().add(postTag.getTagName());
    });
    return BaseResp.ok(new PageDto<>(page));
  }

}
