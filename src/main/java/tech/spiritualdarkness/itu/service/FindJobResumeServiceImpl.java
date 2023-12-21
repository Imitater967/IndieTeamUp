package tech.spiritualdarkness.itu.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.spiritualdarkness.itu.bean.model.FindJobResume;
import tech.spiritualdarkness.itu.dao.FindJobResumeMapper;
import tech.spiritualdarkness.itu.response.Result;
import tech.spiritualdarkness.itu.response.ResumeStatus;

@Service
public class FindJobResumeServiceImpl extends ServiceImpl<FindJobResumeMapper, FindJobResume> implements IFindJobResumeService {
    @Autowired
    FindJobResumeMapper resumeMapper;
    @Override
    public Result<FindJobResume, ResumeStatus> getByUuid(Integer uuid) {
        Result<FindJobResume, ResumeStatus> result = new Result<>();
        var resume = resumeMapper.getById(uuid);
        if(resume == null){
            result.setStatus(ResumeStatus.ResumeNotFound);
            return result;
        }
        result.setStatus(ResumeStatus.ResumeFound);
        result.setData(resume);
        return result;
    }

    @Override
    public Result<FindJobResume, ResumeStatus> update(FindJobResume findJobResume) {
        Result<FindJobResume, ResumeStatus> result = new Result<>();
        resumeMapper.delete(findJobResume.getUuid());
        resumeMapper.insert(findJobResume);

        return null;
    }
}
