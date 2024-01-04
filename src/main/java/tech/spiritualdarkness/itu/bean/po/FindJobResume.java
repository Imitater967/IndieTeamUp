package tech.spiritualdarkness.itu.bean.po;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.spiritualdarkness.itu.bean.enumtype.*;

import java.sql.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("itu_user_person_resume")
public class FindJobResume {
    @NotEmpty
    @TableId
    private Integer uuid;
    @NotEmpty
    private String real_name;
    @NotEmpty
    private int age;
    @NotEmpty
    private WorkType work_type;
    @NotEmpty
    private Sex sex;
    @NotEmpty
    private PayMethod pay_method;
    @NotEmpty
    private WorkMethod work_method;
    @NotEmpty
    private Qualify min_qualify;
    private String current_province;
    private String expect_province;
    @NotEmpty
    private String job;
    @NotEmpty
    private int salary_stock;
    @NotEmpty
    private int salary;
    @NotEmpty
    private String introduce;

    @TableField(exist = false)
    private UserEducation degree;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date update_date;

    @TableField(exist = false)
    private List<UserSkill> user_skills;

}
