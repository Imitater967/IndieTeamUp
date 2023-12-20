package tech.spiritualdarkness.itu.bean.enumtype;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

public enum WorkMethod {
    PART_TIME(1),
    FULL_TIME(2),
    ANY(3);

    @Getter
    @EnumValue
    @JsonValue
    private int id;
    WorkMethod(int id){
        this.id = id;
    }
}
