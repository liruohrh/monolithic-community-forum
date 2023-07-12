package com.liruo.communityforum.model.enumu;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author:liruo
 * @Date:2023-06-15-22:53:18
 * @Desc
 */
@AllArgsConstructor
public enum VerificationCodeType {
  EMAIL("email"), PHONE("phone");
  @Getter
  private final String value;
  public static VerificationCodeType match(String value) {
    if(value == null){
      throw new IllegalArgumentException(
          "illegal value=null " + " for " + VerificationCodeType.class.getSimpleName());
    }
    String lowerValue = value.toLowerCase();
    for (VerificationCodeType e : values()) {
      if (e.getValue().equals(lowerValue)) {
        return e;
      }
    }
    throw new IllegalArgumentException(
        "illegal value " + value + " for " + VerificationCodeType.class.getSimpleName());
  }
}
