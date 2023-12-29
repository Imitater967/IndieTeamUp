package tech.spiritualdarkness.itu.service;

import org.springframework.stereotype.Service;
import tech.spiritualdarkness.itu.bean.model.FindEmployeeResume;
import tech.spiritualdarkness.itu.dao.FindEmployeeResumeMapper;
import tech.spiritualdarkness.itu.bean.vo.response.Result;
import tech.spiritualdarkness.itu.bean.vo.response.ResumeStatus;

import java.util.HashMap;
import java.util.Map;

@Service
public class FindEmployeeServiceImpl implements  IFindEmployeeService{
    final FindEmployeeResumeMapper resumeMapper;

    public FindEmployeeServiceImpl(FindEmployeeResumeMapper resumeMapper) {
        this.resumeMapper = resumeMapper;
    }

    //根据ProjectId筛选
    @Override
    public Result<FindEmployeeResume, ResumeStatus> getById(Integer uuid) {
        Result<FindEmployeeResume,ResumeStatus> result=new Result<>();
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
    public Result<FindEmployeeResume, ResumeStatus> update(FindEmployeeResume findJobResume) {
        Result<FindEmployeeResume,ResumeStatus> result=new Result<>();
        try{
            resumeMapper.deleteById(findJobResume.getPublisher_uuid());
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

    @Override
    public Result<FindEmployeeResume[], ResumeStatus> getByUploaderId(Integer uuid) {
        Result<FindEmployeeResume[],ResumeStatus> result=new Result<>();
        Map<String,Object> columns = new HashMap<>();
        columns.put("publisher_uuid",uuid);
        var resultValues = resumeMapper.selectByMap(columns);
        result.setData((FindEmployeeResume[]) resultValues.toArray());
        result.setStatus(ResumeStatus.ResumeFound);
        return null;
    }
}
