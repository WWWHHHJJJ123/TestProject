package com.whj.common;

import java.util.Arrays;
import java.util.Objects;


/**
 * @Author WHJ
 * @Date 2024/4/23 16:12
 * @Description: TODO
 * @Version 1.0
 */

public enum ErrorCode {

    //系统50开头
    SUCCESS(0, "成功"),
    SYSTEM_ERROR(50000, "系统异常"),
    SYSTEM_JSON_FORMAT_ERROR(50001, "传入参数不是正确的JSON格式"),
    SYSTEM_PARAMETERS_EMPTY(50002, "参数为空"),
    SYSTEM_HTTPMETHOD_ERROR(50003, "不支持此访问方式"),
    SYSTEM_INVALID_IP(50004, "IP无效"),
    ;

    private int code;

    private String message;

    private ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static ErrorCode getParametersDesc(int code) {
        return Arrays.stream(values()).filter(e -> Objects.equals(code, e.code)).findFirst().orElse(SYSTEM_PARAMETERS_EMPTY);
    }
}