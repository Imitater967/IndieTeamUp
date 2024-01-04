package tech.spiritualdarkness.itu.bean.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import tech.spiritualdarkness.itu.bean.enumtype.PayMethod;
import tech.spiritualdarkness.itu.bean.enumtype.Qualify;
import tech.spiritualdarkness.itu.bean.enumtype.WorkMethod;
import tech.spiritualdarkness.itu.bean.enumtype.WorkType;

@NoArgsConstructor
@Data
public abstract class BaseResumeQuery {
    protected boolean desc;
    protected int page;
    protected WorkType workType;
    protected Integer leastSalary;
    protected Integer leastSalaryStock;
    protected WorkMethod workMethod;
    protected PayMethod payMethod;
}
