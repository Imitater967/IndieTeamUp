package tech.spiritualdarkness.itu.service;

import tech.spiritualdarkness.itu.bean.model.FindJobResume;
import tech.spiritualdarkness.itu.response.Result;
import tech.spiritualdarkness.itu.response.ResumeStatus;

public interface IResumeService<U,V extends ResumeStatus> {
    public Result<U, V> getById(Integer uuid);
    public Result<U, V> update(U findJobResume);
}
