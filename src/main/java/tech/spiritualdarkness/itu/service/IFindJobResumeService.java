package tech.spiritualdarkness.itu.service;

import tech.spiritualdarkness.itu.bean.model.FindJobResume;
import tech.spiritualdarkness.itu.response.Result;
import tech.spiritualdarkness.itu.response.ResumeStatus;

public interface IFindJobResumeService {
    public Result<FindJobResume, ResumeStatus> getByUuid(Integer uuid);
    public void update(FindJobResume findJobResume);
}
