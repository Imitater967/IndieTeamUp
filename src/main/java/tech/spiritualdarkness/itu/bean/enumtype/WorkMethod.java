package tech.spiritualdarkness.itu.bean.enumtype;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

public enum WorkMethod {
    PART_TIME(1, "兼职"),
    FULL_TIME(2, "全职"),
    ANY(3, "均可");


    @Getter
    @EnumValue
    private String desc;

    @JsonValue
    private Integer id;

    WorkMethod(int id, String desc) {
        this.id = id;
        this.desc = desc;

    }

}
