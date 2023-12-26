package tech.spiritualdarkness.itu.service;

import tech.spiritualdarkness.itu.bean.model.FindJobResume;
import tech.spiritualdarkness.itu.bean.model.UserEducation;
import tech.spiritualdarkness.itu.response.Result;
import tech.spiritualdarkness.itu.response.ResumeStatus;

public interface IFindJobResumeService extends IResumeService<FindJobResume,ResumeStatus>{
    public Result<FindJobResume,ResumeStatus> updateDegree(FindJobResume resume);
}
