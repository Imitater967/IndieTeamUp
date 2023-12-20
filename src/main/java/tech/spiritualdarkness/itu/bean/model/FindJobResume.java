package tech.spiritualdarkness.itu.bean.model;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import tech.spiritualdarkness.itu.bean.enumtype.*;

@Data
public class FindJobResume {
    @NotEmpty
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
    private String first_job;
    private String second_job;
    @NotEmpty
    private int salary_stock;
    @NotEmpty
    private int salary;
    @NotEmpty
    private String introduce;

}