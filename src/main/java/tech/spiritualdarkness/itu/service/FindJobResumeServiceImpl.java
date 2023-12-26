package tech.spiritualdarkness.itu.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import tech.spiritualdarkness.itu.bean.enumtype.EducationDegree;
import tech.spiritualdarkness.itu.bean.model.FindJobResume;
import tech.spiritualdarkness.itu.bean.model.UserEducation;
import tech.spiritualdarkness.itu.dao.EducationDegreeMapper;
import tech.spiritualdarkness.itu.dao.FindJobResumeMapper;
import tech.spiritualdarkness.itu.response.Result;
import tech.spiritualdarkness.itu.response.ResumeStatus;

import java.sql.Date;

@Service
public class FindJobResumeServiceImpl extends ServiceImpl<FindJobResumeMapper, FindJobResume> implements IFindJobResumeService {
    final FindJobResumeMapper resumeMapper;
    final EducationDegreeMapper degreeMapper;

    public FindJobResumeServiceImpl(FindJobResumeMapper resumeMapper, EducationDegreeMapper degreeMapper) {
        this.resumeMapper = resumeMapper;
        this.degreeMapper = degreeMapper;
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
            updateDegree(findJobResume);
            result.setData(findJobResume);
            result.setStatus(ResumeStatus.ResumeUpdated);
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }
        result.setStatus(ResumeStatus.ResumeNotFound);
        return result;
    }

    @Override
    public Result<FindJobResume, ResumeStatus> updateDegree(FindJobResume education) {

        Result<FindJobResume, ResumeStatus> result = new Result<>();
        try{
            var degree = education.getDegree();
            degreeMapper.deleteById(education.getUuid());
            degreeMapper.insert(degree);
            education.setDegree(degree);
            result.setData(education);
            result.setStatus(ResumeStatus.ResumeUpdated);
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }
        result.setStatus(ResumeStatus.ResumeNotFound);
        return result;
    }
}
