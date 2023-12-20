package tech.spiritualdarkness.itu.bean.enumtype;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

public enum Sex {
    Male(1), Female(2);

    @EnumValue
    @Getter
    @JsonValue
    int id;
    Sex(int id){
        this.id = id;
    }
}
