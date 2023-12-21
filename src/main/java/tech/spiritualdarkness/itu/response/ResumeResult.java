package tech.spiritualdarkness.itu.response;

public class ResumeResult extends Status {
    public static ResumeResult ResumeFound = new ResumeResult(200,true,"找到简历");
    public static ResumeResult ResumeNotFound = new ResumeResult(300,false,"简历不存在");
    public static ResumeResult ResumeUnavailable = new ResumeResult(301,false,"简历审核中");
    public ResumeResult(int code, boolean success, String msg) {
        super(code, success, msg);
    }
}
