package com.yili.common.result;

import lombok.Getter;

@Getter
public enum ResultEnum {
    SUCCESS(200,"成功"),
    FAIL(400, "失败"),

    SERVICE_ERROR(403, "服务异常"),
    DATA_ERROR(404, "数据异常"),
    ILLEGAL_REQUEST(405, "非法请求"),
    REPEAT_SUBMIT(406, "重复提交"),

    LOGIN_AUTH(408, "未登陆"),
    PERMISSION(409, "没有权限"),

    EMAIL_Valid(410,"邮箱不合法"),
    USER_IS_EXIST(411,"用户已存在"),
    ACCOUNT_OR_PASSWORD_WRONG(412,"用户名或密码错误！")
    ;
    private final Integer code;

    private final String message;


    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
