package tech.spiritualdarkness.itu.bean.vo.response;

public class ContactStatus extends Status{
    public static ContactStatus Success = new ContactStatus(200,true,"成功");
    public static ContactStatus Fail = new ContactStatus(300,false,"用户不存在或者没有权限");

    public ContactStatus(int code, boolean success, String msg) {
        super(code, success, msg);
    }
}
