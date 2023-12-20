package tech.spiritualdarkness.itu.bean.model;

import lombok.Data;
import tech.spiritualdarkness.itu.bean.enumtype.*;

@Data
public class FindJobResume {
    private String real_name;
    private int age;
    private WorkType work_type;
    private Sex sex;
    private PayMethod pay_method;
    private WorkMethod work_method;
    private Qualify min_qualify;
}
