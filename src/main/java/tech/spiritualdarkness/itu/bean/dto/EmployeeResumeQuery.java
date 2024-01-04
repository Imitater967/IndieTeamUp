package tech.spiritualdarkness.itu.bean.dto;

import lombok.Data;

/**
 * 查询员工简历
 */

@Data
public class EmployeeResumeQuery extends BaseResumeQuery{
    protected String job;
}
