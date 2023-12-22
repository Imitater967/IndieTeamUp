package tech.spiritualdarkness.itu.bean.enumtype;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

public enum Sex {
    Male(1,"男"), Female(2,"女");

    @JsonValue
    Integer id;

    @Getter
    @EnumValue
    String desc;

    Sex(int id, String desc) {
        this.desc = desc;
        this.id = id;
    }
}
