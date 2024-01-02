package tech.spiritualdarkness.itu.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.spiritualdarkness.itu.bean.po.FindEmployeeResume;
import tech.spiritualdarkness.itu.bean.po.ProjectProgress;
import tech.spiritualdarkness.itu.dao.FindEmployeeResumeMapper;
import tech.spiritualdarkness.itu.bean.vo.response.Result;
import tech.spiritualdarkness.itu.bean.vo.response.ResumeStatus;
import tech.spiritualdarkness.itu.dao.ProjectProgressMapper;

import java.util.HashMap;
import java.util.Map;

@Service
public class FindEmployeeServiceImpl implements  IFindEmployeeService{
    final FindEmployeeResumeMapper resumeMapper;
    @Autowired
    ProjectProgressMapper progressMapper;

    public FindEmployeeServiceImpl(FindEmployeeResumeMapper resumeMapper) {
        this.resumeMapper = resumeMapper;
    }

    //根据ProjectId筛选
    @Override
    public Result<FindEmployeeResume, ResumeStatus> getById(Integer uuid) {
        //查找基础简历
        Result<FindEmployeeResume,ResumeStatus> result=new Result<>();
        var resume = resumeMapper.selectById(uuid);
        if(resume == null){
            result.setStatus(ResumeStatus.ResumeNotFound);
            return result;
        }
        result.setStatus(ResumeStatus.ResumeFound);
        result.setData(resume);

        //链表查询
        QueryWrapper skillQuery = new QueryWrapper();
        skillQuery.eq("project_id",uuid);
        resume.setProgress(progressMapper.selectList(skillQuery));

        return result;
    }

    @Override
    public Result<FindEmployeeResume, ResumeStatus> update(FindEmployeeResume findJobResume) {
        Result<FindEmployeeResume,ResumeStatus> result=new Result<>();
        try{
            resumeMapper.deleteById(findJobResume.getPublisher_uuid());
            resumeMapper.insert(findJobResume);
            updateProjectProgress(findJobResume);
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
    public Result<FindEmployeeResume[], ResumeStatus> getByUploaderId(Integer uuid) {
//        Result<FindEmployeeResume[],ResumeStatus> result=new Result<>();
//        Map<String,Object> columns = new HashMap<>();
//        columns.put("publisher_uuid",uuid);
//        var resultValues = resumeMapper.selectByMap(columns);
//        result.setData((FindEmployeeResume[]) resultValues.toArray());
//        result.setStatus(ResumeStatus.ResumeFound);
        return null;
    }

    public void updateProjectProgress(FindEmployeeResume resume){
        var uuid = resume.getPublisher_uuid();
        var progresses = resume.getProgress();

        progressMapper.deleteById(uuid);

        for (ProjectProgress progress : progresses) {
            progressMapper.insert(progress);
        }
    }
}
