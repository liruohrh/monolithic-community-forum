package com.liruo.communityforum.model.dto;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.io.Serializable;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author:liruo
 * @Date:2023-06-16-10:47:09
 * @Desc
 */
@Data
@NoArgsConstructor
public class PageDto<T> implements Serializable {

  public PageDto(Page<T> iPage) {
    this.records = iPage.getRecords();
    this.total = iPage.getTotal();
    this.currentPage = iPage.getCurrent();
    this.hasNext = iPage.hasNext();
    this.hasPrevious = iPage.hasPrevious();
  }

  private List<T> records;
  private Long total;
  private Long currentPage;
  private Boolean hasNext;
  private Boolean hasPrevious;
  private static final long serialVersionUID = 1L;
}
