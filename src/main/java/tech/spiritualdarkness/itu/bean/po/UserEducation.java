package tech.spiritualdarkness.itu.bean.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.spiritualdarkness.itu.bean.enumtype.EducationDegree;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("itu_user_person_education")
public class UserEducation {
    @TableId
    private Integer uuid;
    private EducationDegree degree;
    private String university;
    private Date graduate;
}
