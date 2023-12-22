package tech.spiritualdarkness.itu.bean.enumtype;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

public enum Qualify {
    NONE(1,"无"),
    PERSONAL(2,"个体户"),
    SMALL_COMPANY(3,"小规模"),
    NORMAL_COMPANY(4,"一般");

    @JsonValue
    private Integer id;

    @Getter
    @EnumValue

    private String desc;

    Qualify(int id,String desc)
    {
        this.desc = desc;
        this.id = id;
    }

}
