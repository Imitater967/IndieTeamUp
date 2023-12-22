package tech.spiritualdarkness.itu.bean.enumtype;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

public enum NextFinishStage {
    Demo(1,"Demo"),
    Release(2,"正式发行"),
    Updating(3,"版本更新");

    @JsonValue
    private Integer id;

    @Getter
    @EnumValue
    private String desc;
    NextFinishStage(int id, String desc){
        this.id = id;
        this.desc = desc;
    }
}
