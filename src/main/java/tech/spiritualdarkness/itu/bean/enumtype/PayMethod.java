package tech.spiritualdarkness.itu.bean.enumtype;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

public enum PayMethod {
    FREE(1, "免费"),
    MONTHLY(2, "月薪"),
    OUTSOURCE(3, "外包"),
    Any(4, "均可");

    @JsonValue
    private Integer id;

    @Getter
    @EnumValue
    private String desc;

    PayMethod(int id,String desc) {
        this.id = id;
        this.desc = desc;
    }
}
