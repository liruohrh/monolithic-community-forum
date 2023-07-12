package com.liruo.communityforum.infrasturcture.mvc;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @Author:liruo
 * @Date:2023-06-10-17:07:48
 * @Desc
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class BaseResp<T> {
    private T data;
    private String message;
    private Integer code;
    public BaseResp() {
    }

    public BaseResp(T data, Integer code) {
        this.data = data;
        this.code = code;
    }
    public BaseResp(String message, Integer code) {
        this.message = message;
        this.code = code;
    }
    public BaseResp(ErrorCode errorCode) {
        this.message = errorCode.message;
        this.code = errorCode.code;
    }

    public static <D> BaseResp<D> ok(D data) {
        return new BaseResp<>(data, ErrorCode.OK.code);
    }
    public static <D> BaseResp<D> fail(String message, ErrorCode errorCode) {
        return new BaseResp<>(message, errorCode.code);
    }
    public static <D> BaseResp<D> fail(ErrorCode errorCode) {
        return new BaseResp<>(errorCode.message, errorCode.code);
    }
}
