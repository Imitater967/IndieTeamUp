package tech.spiritualdarkness.itu.response;

import lombok.Getter;

@Getter
public enum ResultStatus {
    UserSignUpNameExists(false,"10001","该用户已存在"),
    UserSignUpSucceed(true,"10002","注册用户成功"),
    UserSignInFail(false,"10003","验证码错误"),
    UserSignInSucceed(true,"10004","登录成功"),
    UserStatusNotUnlogged(false,"10007","用户未登录,"),
    UserStatusNotValid(false,"10008","用户不存在或session信息为空"),
    UserStatusLogged(true,"10009","用户已登录");

    private final String code;
    private final String msg;
    private final boolean success;

    ResultStatus(boolean success, String code, String msg){
        this.code = code;
        this.msg = msg;
        this.success = success;
    }
}
