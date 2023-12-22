package tech.spiritualdarkness.itu.bean.enumtype;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

public enum EducationDegree {
    ASSOCIATED(1,"大专"),
    BACHELOR(2,"本科"),
    MASTER(3,"硕士及以上");

    @JsonValue
    private Integer id;

    @Getter
    @EnumValue
    private String desc;
    EducationDegree(int id, String desc){
        this.id = id;
        this.desc=desc;
    }
}
