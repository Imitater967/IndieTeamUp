package tech.spiritualdarkness.itu.bean.enumtype;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;


public enum WorkType {
    WORK_AT_HOME(1),
    WORK_AT_COMPANY(2),
    ANY(3);

    @Getter
    @EnumValue
    @JsonValue
    private int id;
    WorkType(int id){
        this.id = id;
    }
}
