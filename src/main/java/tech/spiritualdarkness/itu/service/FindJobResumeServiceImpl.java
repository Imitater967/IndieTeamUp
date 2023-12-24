package tech.spiritualdarkness.itu.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.spiritualdarkness.itu.bean.model.FindJobResume;
import tech.spiritualdarkness.itu.dao.FindJobResumeMapper;
import tech.spiritualdarkness.itu.response.Result;
import tech.spiritualdarkness.itu.response.ResumeStatus;

@Service
public class FindJobResumeServiceImpl extends ServiceImpl<FindJobResumeMapper, FindJobResume> implements IFindJobResumeService {
    final
    FindJobResumeMapper resumeMapper;

    public FindJobResumeServiceImpl(FindJobResumeMapper resumeMapper) {
        this.resumeMapper = resumeMapper;
    }

    @Override
    public Result<FindJobResume, ResumeStatus> getById(Integer uuid) {
        Result<FindJobResume, ResumeStatus> result = new Result<>();
        var resume = resumeMapper.selectById(uuid);
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
        try{
            resumeMapper.deleteById(findJobResume.getUuid());
            resumeMapper.insert(findJobResume);

            result.setData(findJobResume);
            result.setStatus(ResumeStatus.ResumeUpdated);
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }
        result.setStatus(ResumeStatus.ResumeNotFound);
        return result;
    }
}
