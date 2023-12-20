package tech.spiritualdarkness.itu.bean.enumtype;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

public enum Qualify {
    NONE(1),
    PERSONAL(2),
    SMALL_COMPANY(3),
    NORMAL_COMPANY(4);

    @Getter
    @EnumValue
    @JsonValue
    private int id;

    Qualify(int id) {
        this.id = id;
    }

}
