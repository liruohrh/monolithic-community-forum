package com.liruo.communityforum.controller;

import com.liruo.communityforum.model.domain.Tag;
import com.liruo.communityforum.infrasturcture.mvc.BaseResp;
import com.liruo.communityforum.service.TagService;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author:liruo
 * @Date:2023-06-15-21:14:19
 * @Desc
 */
@RequestMapping("/tag")
@RestController
public class TagController {

  @Resource
  private TagService tagService;

  @GetMapping("/list")
  public BaseResp<List<String>> list() {
    return BaseResp.ok(tagService.list().stream().map(Tag::getName).collect(Collectors.toList()));
  }

}
