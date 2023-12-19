package tech.spiritualdarkness.itu.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Status {
    private int code;
    private boolean success;
    private String msg;
    public static Status success(int code,String msg){
        return new Status(code,true,msg);
    }
    public static Status error(int code,String msg){
        return new Status(code,false,msg);
    }
}
