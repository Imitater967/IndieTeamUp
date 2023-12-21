package tech.spiritualdarkness.itu.bean.enumtype;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

public enum EducationDegree {
    ASSOCIATED(1),
    BACHELOR(2),
    MASTER(3);

    @Getter
    @EnumValue
    @JsonValue
    private int id;
    EducationDegree(int id){
        this.id = id;
    }
}
