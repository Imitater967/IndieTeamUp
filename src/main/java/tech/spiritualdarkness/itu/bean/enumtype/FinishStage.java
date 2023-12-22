package tech.spiritualdarkness.itu.bean.enumtype;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

public enum FinishStage {
    Preparing(1,"未开工"),
    Demo(2,"Demo"),
    Release(3,"正式发行"),
    Updating(4,"版本更新");

    @JsonValue
    private Integer id;

    @Getter
    @EnumValue
    private String desc;
    FinishStage(int id, String desc){
        this.id = id;
        this.desc = desc;
    }
}
