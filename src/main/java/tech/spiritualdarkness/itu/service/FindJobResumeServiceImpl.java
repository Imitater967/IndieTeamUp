package tech.spiritualdarkness.itu.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import tech.spiritualdarkness.itu.bean.model.FindJobResume;
import tech.spiritualdarkness.itu.bean.model.UserSkill;
import tech.spiritualdarkness.itu.dao.EducationDegreeMapper;
import tech.spiritualdarkness.itu.dao.FindJobResumeMapper;
import tech.spiritualdarkness.itu.dao.SkillMapper;
import tech.spiritualdarkness.itu.bean.vo.response.Result;
import tech.spiritualdarkness.itu.bean.vo.response.ResumeStatus;

@Service
public class FindJobResumeServiceImpl extends ServiceImpl<FindJobResumeMapper, FindJobResume> implements IFindJobResumeService {
    final FindJobResumeMapper resumeMapper;
    final EducationDegreeMapper degreeMapper;
    final SkillMapper skillMapper;

    public FindJobResumeServiceImpl(FindJobResumeMapper resumeMapper, EducationDegreeMapper degreeMapper, SkillMapper skillMapper) {
        this.resumeMapper = resumeMapper;
        this.degreeMapper = degreeMapper;
        this.skillMapper = skillMapper;
    }

    @Override
    public Result<FindJobResume, ResumeStatus> getById(Integer uuid) {
        Result<FindJobResume, ResumeStatus> result = new Result<>();
        var resume = resumeMapper.selectById(uuid);
        if(resume == null){
            result.setStatus(ResumeStatus.ResumeNotFound);
            return result;
        }
        QueryWrapper skillQuery = new QueryWrapper();
        skillQuery.eq("uuid",uuid);
        resume.setUser_skills(skillMapper.selectList(skillQuery));
        resume.setDegree(degreeMapper.selectById(uuid));
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
    public Result<FindJobResume, ResumeStatus> updateDegree(FindJobResume resume) {

        Result<FindJobResume, ResumeStatus> result = new Result<>();
        try{
            var degree = resume.getDegree();
            degreeMapper.deleteById(resume.getUuid());
            degreeMapper.insert(degree);
            skillMapper.deleteById(resume.getUuid());
            if(resume.getUser_skills()!=null){
                for (UserSkill userSkill : resume.getUser_skills()) {
                    skillMapper.insert(userSkill);
                }
            }
            result.setData(resume);
            result.setStatus(ResumeStatus.ResumeUpdated);
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }
        result.setStatus(ResumeStatus.ResumeNotFound);
        return result;
    }
}
