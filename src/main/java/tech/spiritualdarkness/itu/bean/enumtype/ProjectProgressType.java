package tech.spiritualdarkness.itu.bean.enumtype;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

public enum ProjectProgressType {

    Progress(1,"总进度"),
    GameDesign(2, "设计"),
    PictureAsset(3, "精灵资产"),
    ModelAsset(4, "模型资产"),
    TextureAsset(5, "贴图资产"),
    MaterialAsset(6, "材质资产"),
    AnimationAsset(7,"动画资产"),
    AudioAsset(8,"音效资产"),
    GUI(9,"UI资产"),
    FrameWork(10,"程序资产");
    @JsonValue
    private Integer id;

    @Getter
    @EnumValue
    private String desc;

    ProjectProgressType(int id,String desc) {
        this.id = id;
        this.desc = desc;
    }
}
