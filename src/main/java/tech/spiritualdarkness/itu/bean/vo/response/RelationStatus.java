package tech.spiritualdarkness.itu.bean.vo.response;

public class RelationStatus extends Status{

    public static RelationStatus QuerySuccess = new RelationStatus(202,true,"查询成功");
    public static RelationStatus FriendCompanySuccess = new RelationStatus(201,true,"成功粉公司");
    public static RelationStatus FriendEmployeeSuccess = new RelationStatus(202,true,"成功粉员工");
    public static RelationStatus ArgError = new RelationStatus(300,false,"参数错误");
    public static RelationStatus UnFriendCompanySuccess = new RelationStatus(203,true,"成功取消粉公司");
    public static RelationStatus UnFriendEmployeeSuccess = new RelationStatus(204,true,"成功取消粉员工");
    public RelationStatus(int code, boolean success, String msg) {
        super(code, success, msg);
    }
}
