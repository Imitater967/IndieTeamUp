package tech.spiritualdarkness.itu.response;

import lombok.Getter;

@Getter
public enum ResultStatus {
    OK(true,"001","登录成功");

    private final String code;
    private final String msg;
    private final boolean success;

    ResultStatus(boolean success, String code, String msg){
        this.code = code;
        this.msg = msg;
        this.success = success;
    }
}
