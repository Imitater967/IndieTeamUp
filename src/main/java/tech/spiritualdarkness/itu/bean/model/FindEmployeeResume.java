package tech.spiritualdarkness.itu.bean.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.spiritualdarkness.itu.bean.enumtype.*;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("itu_project_resume")
public class FindEmployeeResume {

    @TableId
    private Integer publisher_uuid;
    private String introduce;
    private FinishStage finish_stage;
    private GameType game_type;
    private Qualify qualify;
    private int salary_stock;
    private int salary;
    private int finance;
    private Date finish_date;
    private PayMethod pay_method;
    private WorkMethod work_method;

}
