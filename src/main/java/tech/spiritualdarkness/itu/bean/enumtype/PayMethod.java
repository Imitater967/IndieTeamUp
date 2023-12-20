package tech.spiritualdarkness.itu.bean.enumtype;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

public enum PayMethod {
    FREE(1),
    MONTHLY(2),
    OUTSOURCE(3),
    MONTHLY_OR_OUTSOURCE(4);

    @Getter
    @EnumValue
    @JsonValue
    private int id;
    PayMethod(int id){
        this.id = id;
    }
}
