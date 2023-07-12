package com.liruo.communityforum.infrasturcture.mvc;

import lombok.AllArgsConstructor;

/**
 * @Author:liruo
 * @Date:2023-06-10-17:09:07
 * @Desc
 */
@AllArgsConstructor
public enum ErrorCode {
    OK("ok", 0),
    REQUEST_PARAMETER("err parameters", 400),
    UNAUTHORIZED("认证错误", 403),
    SYSTEM("system err", 500);
    public final String message;
    public final Integer code;
}
