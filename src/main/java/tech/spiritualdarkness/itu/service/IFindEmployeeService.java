package tech.spiritualdarkness.itu.service;

import tech.spiritualdarkness.itu.bean.model.FindEmployeeResume;
import tech.spiritualdarkness.itu.bean.model.FindJobResume;
import tech.spiritualdarkness.itu.response.Result;
import tech.spiritualdarkness.itu.response.ResumeStatus;

public interface IFindEmployeeService extends IResumeService<FindEmployeeResume, ResumeStatus> {

    public Result<FindEmployeeResume[], ResumeStatus> getByUploaderId(Integer uuid);
}
