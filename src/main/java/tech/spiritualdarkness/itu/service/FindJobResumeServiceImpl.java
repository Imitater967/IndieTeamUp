package tech.spiritualdarkness.itu.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.spiritualdarkness.itu.bean.model.FindJobResume;
import tech.spiritualdarkness.itu.dao.FindJobResumeMapper;

@Service
public class FindJobResumeServiceImpl extends ServiceImpl<FindJobResumeMapper, FindJobResume> implements IFindJobResumeService {
    @Autowired
    FindJobResumeMapper resumeMapper;
    @Override
    public FindJobResume getByUuid(Integer uuid) {
        return null;
    }

    @Override
    public void update(FindJobResume findJobResume) {

    }
}
