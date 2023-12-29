package tech.spiritualdarkness.itu.service;

import tech.spiritualdarkness.itu.bean.model.FindEmployeeResume;
import tech.spiritualdarkness.itu.bean.vo.response.Result;
import tech.spiritualdarkness.itu.bean.vo.response.ResumeStatus;

public interface IFindEmployeeService extends IResumeService<FindEmployeeResume, ResumeStatus> {

    public Result<FindEmployeeResume[], ResumeStatus> getByUploaderId(Integer uuid);
}
