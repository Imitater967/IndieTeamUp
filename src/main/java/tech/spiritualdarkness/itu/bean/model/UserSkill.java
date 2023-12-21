package tech.spiritualdarkness.itu.bean.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.spiritualdarkness.itu.bean.enumtype.EducationDegree;

import java.sql.Date;

@Data
@NoArgsConstructor
@TableName("itu_user_person_education")
public class UserSkill {
    private Integer uuid;
    private String skill_name;
    private int skill_level;
}