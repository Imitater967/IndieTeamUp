package tech.spiritualdarkness.itu.bean.enumtype;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

public enum GameType {
    RolePlay(1,"角色扮演"),
    Casual(2,"休闲"),
    Act(3,"动作"),
    Strategy(4,"策略"),
    Simulation(5,"模拟"),
    Puzzle(6,"益智"),
    Arcade(7,"街机"),
    Adventure(8,"冒险"),
    Cards(8,"卡牌"),
    Sports(10,"体育"),
    QA(11,"知识问答"),
    Education(12,"教育"),
    Music(13,"音乐"),
    ;
    @JsonValue
    private Integer id;
    @Getter
    @EnumValue
    private String desc;
    GameType(int id, String desc){
        this.id = id;
        this.desc = desc;
    }
}
