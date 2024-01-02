package tech.spiritualdarkness.itu.bean.enumtype;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

public enum ProjectProgressStatus {
    Unknown(1,"未计算"),
    Preparing(2,"筹备中"),
    Working(3,"工作中"),
    Dynamic(4,"动态");


    @JsonValue
    private Integer id;

    @Getter
    @EnumValue
    private String desc;

    ProjectProgressStatus(int id,String desc) {
        this.id = id;
        this.desc = desc;
    }
}
