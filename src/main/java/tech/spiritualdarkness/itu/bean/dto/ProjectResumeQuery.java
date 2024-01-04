package tech.spiritualdarkness.itu.bean.dto;

import lombok.Data;
import tech.spiritualdarkness.itu.bean.enumtype.FinishStage;
import tech.spiritualdarkness.itu.bean.enumtype.Qualify;


@Data
public class ProjectResumeQuery extends BaseResumeQuery{
    protected Qualify minQualify;
    protected Integer finance;
    protected FinishStage finishStage;
}
