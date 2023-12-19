package tech.spiritualdarkness.itu.response;


/**
 * @author Megumin
 */
public class UserResultStatus extends Status{
    public static UserResultStatus UserExits = new UserResultStatus(300,false,"用户名重复");
    public static UserResultStatus RegisteredSuccessfully = new UserResultStatus(200,true,"注册成功");
    public UserResultStatus(int code, boolean success, String msg) {
        super(code, success, msg);
    }
}
