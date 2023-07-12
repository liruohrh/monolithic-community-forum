package com.liruo.communityforum.model.enumu;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author:liruo
 * @Date:2023-06-15-22:53:18
 * @Desc
 */
@AllArgsConstructor
public enum Gender {
  MAN(0), WOMAN(1);
  @Getter
  @EnumValue
  private final int value;
  public static Gender match(int value){
    for (Gender e : values()) {
      if(e.getValue() == value){
        return e;
      }
    }
    throw new IllegalArgumentException("illegal value " + value + " for " + Gender.class.getSimpleName());
  }
}
