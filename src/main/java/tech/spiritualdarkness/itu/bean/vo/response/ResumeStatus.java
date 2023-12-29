package tech.spiritualdarkness.itu.bean.vo.response;

public class ResumeStatus extends Status {
    public static ResumeStatus ResumeFound = new ResumeStatus(200,true,"找到简历");
    public static ResumeStatus ResumeUpdated = new ResumeStatus(201,true,"更新成功");
    public static ResumeStatus ResumeNotFound = new ResumeStatus(300,false,"简历不存在");
    public static ResumeStatus ResumeUnavailable = new ResumeStatus(302,false,"简历审核中");
    public static ResumeStatus ArgError  = new ResumeStatus(301,false,"Uuid错误");

    public ResumeStatus(int code, boolean success, String msg) {
        super(code, success, msg);
    }
}
