package com.liruo.communityforum.infrasturcture.util;

import java.nio.charset.StandardCharsets;
import org.springframework.util.DigestUtils;

/**
 * @Author:liruo
 * @Date:2023-06-15-21:28:45
 * @Desc
 */
public class DigestUtil {
  public static String encode(String row){
    return DigestUtils.md5DigestAsHex(row.getBytes(StandardCharsets.UTF_8));
  }
}
