package tech.spiritualdarkness.itu.response;

import lombok.Data;

@Data
public class Status {
    private int code;
    private boolean success;
    private String msg;
}
