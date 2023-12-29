package tech.spiritualdarkness.itu.bean.vo.relation;

import java.util.ArrayList;
import java.util.List;

public class Relationship {
    //朋友UUID
    public List<Integer> friends = new ArrayList<>();
    //已发送请求的UUID
    public List<Integer> sentInvitations = new ArrayList<>();
    //已收到请求的UUID
    public List<Integer> receivedInvitations = new ArrayList<>();
}
