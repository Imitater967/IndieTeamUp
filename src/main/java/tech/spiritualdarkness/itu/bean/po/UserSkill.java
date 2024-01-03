package tech.spiritualdarkness.itu.bean.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@TableName("itu_user_person_skill")
public class UserSkill {
    @TableId
    private Integer uuid;
    private String skill_name;
    private int skill_level;
    private Date start_time;
    private Date end_time;
    private String company;
    private String project;
    private String url;
}