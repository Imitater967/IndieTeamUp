package tech.spiritualdarkness.itu.service;

import tech.spiritualdarkness.itu.bean.model.FindJobResume;

public interface IFindJobResumeService {
    public FindJobResume getByUuid(Integer uuid);
    public void update(FindJobResume findJobResume);
}
