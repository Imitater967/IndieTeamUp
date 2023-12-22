package tech.spiritualdarkness.itu.bean.enumtype;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;


public enum WorkType {
    WORK_AT_HOME(1,"线上"),
    WORK_AT_COMPANY(2,"线下"),
    ANY(3,"线上或线下");

    @JsonValue
    private Integer id;

    @Getter
    @EnumValue
    private String desc;
    WorkType(int id,String desc){
        this.id = id;
        this.desc = desc;
    }
}
