package tech.spiritualdarkness.itu.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.spiritualdarkness.itu.bean.dto.EmployeeResumeQuery;
import tech.spiritualdarkness.itu.bean.dto.ProjectResumeQuery;
import tech.spiritualdarkness.itu.bean.vo.response.Result;
import tech.spiritualdarkness.itu.bean.vo.response.Status;
import tech.spiritualdarkness.itu.service.QueryService;

@Slf4j
@RestController
@RequestMapping("/query")
public class QueryController {

    @Autowired
    QueryService queryService;
    @PostMapping("/employee")
    public Result<IPage, Status> queryEmployees(
            @RequestBody EmployeeResumeQuery bean
    ){
        Result<IPage, Status> result = new Result();
        var resultData = queryService.findJobResumes(bean);
        result.setData(resultData);
        result.setStatus(Status.success(200,"成功"));
        return result;
    }
    @PostMapping("/project")
    public Result<IPage, Status> queryProjects(
            @RequestBody ProjectResumeQuery bean
    ){
        Result<IPage, Status> result = new Result();
        var resultData = queryService.findProjectResumes(bean);
        result.setData(resultData);
        result.setStatus(Status.success(200,"成功"));
        return result;
    }
}
