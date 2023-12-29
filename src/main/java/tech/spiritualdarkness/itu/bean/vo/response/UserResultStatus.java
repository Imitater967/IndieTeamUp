package tech.spiritualdarkness.itu.bean.vo.response;


/**
 * @author Megumin
 */
public class UserResultStatus extends Status{
    public static UserResultStatus UserExits = new UserResultStatus(300,false,"用户名重复");
    public static UserResultStatus RegisteredSuccessfully = new UserResultStatus(200,true,"注册成功");

    public static UserResultStatus LoginFail = new UserResultStatus(300,false,"用户名和密码不匹配");
    public static UserResultStatus LoginSuccess = new UserResultStatus(200,true,"登录成功");
    public static UserResultStatus LoginSuccessAuto = new UserResultStatus(201,true,"自动登录成功");
    public UserResultStatus(int code, boolean success, String msg) {
        super(code, success, msg);
    }
}
